package database;

import interfaces.IBoat;
import interfaces.IDatabase;
import interfaces.IEngine;
import interfaces.IRepository;

public class BoatSimulatorDatabase implements IDatabase {
    private IRepository<IBoat> boats;
    private IRepository<IEngine> engines;

    public BoatSimulatorDatabase() {
        this.setBoats(new Repository<>());
        this.setEngines(new Repository<>());
    }

    public IRepository<IBoat> getBoats() {
        return this.boats;
    }

    private void setBoats(IRepository<IBoat> boats) {
        this.boats = boats;
    }

    public IRepository<IEngine> getEngines() {
        return this.engines;
    }

    private void setEngines(IRepository<IEngine> engines) {
        this.engines = engines;
    }
}
