package cresla.manager;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.*;
import cresla.models.modules.CooldownSystem;
import cresla.models.modules.CryogenRod;
import cresla.models.modules.HeatProcessor;
import cresla.models.reactor.CryoReactor;
import cresla.models.reactor.HeatReactor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager{
    private Map<Integer, Reactor> reactorMap;
    private Map<Integer, Module> moduleMap;
    private int id;
    private int energyModuleCounter;
    private int absorbingModuleCounter;
    private int cryoReactorCounter;
    private int heatReactorCounter;

    public ManagerImpl() {
        this.reactorMap = new HashMap<>();
        this.moduleMap = new HashMap<>();
        this.id = 1;
        this.energyModuleCounter = 0;
        this.absorbingModuleCounter = 0;
        this.cryoReactorCounter = 0;
        this.heatReactorCounter = 0;
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        Container container = new ModuleContainer(Integer.valueOf(arguments.get(2)));
        if ("Cryo".equalsIgnoreCase(arguments.get(0))) {
            this.reactorMap.put(this.id, new CryoReactor(this.id, container, Integer.valueOf(arguments.get(1))));
            this.cryoReactorCounter++;
        } else {
            this.reactorMap.put(this.id, new HeatReactor(this.id, container, Integer.valueOf(arguments.get(1))));
            this.heatReactorCounter++;
        }
        return "Created " + arguments.get(0) + " Reactor - " + this.id++ + System.lineSeparator();
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        int reactorId = Integer.parseInt(arguments.get(0));
        switch (arguments.get(1)) {
            case "CryogenRod":
                EnergyModule module = new CryogenRod(this.id, Integer.parseInt(arguments.get(2)));
                this.reactorMap.get(reactorId).addEnergyModule(module);
                this.moduleMap.put(this.id, module);
                this.energyModuleCounter++;
                break;
            case "HeatProcessor":
                AbsorbingModule module1 = new HeatProcessor(this.id, Integer.parseInt(arguments.get(2)));
                this.reactorMap.get(reactorId).addAbsorbingModule(module1);
                this.moduleMap.put(this.id, module1);
                this.absorbingModuleCounter++;
                break;
            case "CooldownSystem":
                AbsorbingModule module2 = new CooldownSystem(this.id, Integer.parseInt(arguments.get(2)));
                this.reactorMap.get(reactorId).addAbsorbingModule(module2);
                this.moduleMap.put(this.id, module2);
                this.absorbingModuleCounter++;
                break;
                default:
                    break;
        }
        return "Added " + arguments.get(1) + " - " + this.id++ + " to Reactor - " + reactorId;
    }

    @Override
    public String reportCommand(List<String> arguments) {
        int targetId = Integer.parseInt(arguments.get(0));
        if (this.reactorMap.containsKey(targetId)) {
            return this.reactorMap.get(targetId).toString();
        } else {
            return this.moduleMap.get(targetId).toString();
        }
    }

    @Override
    public String exitCommand(List<String> arguments) {
        long totalEnergy = this.reactorMap.entrySet().stream().mapToLong(r -> r.getValue().getTotalEnergyOutput()).sum();
        long totalHeat = this.reactorMap.entrySet().stream().mapToLong(r -> r.getValue().getTotalHeatAbsorbing()).sum();

        return "Cryo Reactors: " + this.cryoReactorCounter + System.lineSeparator() +
                "Heat Reactors: " + this.heatReactorCounter + System.lineSeparator() +
                "Energy Modules: " + this.energyModuleCounter + System.lineSeparator() +
                "Absorbing Modules: " + this.absorbingModuleCounter + System.lineSeparator() +
                "Total Energy Output: " + totalEnergy + System.lineSeparator() +
                "Total Heat Absorbing: " +  totalHeat;
    }
}
