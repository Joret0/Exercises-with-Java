package core;

import enumeration.EngineType;
import exeptions.*;
import interfaces.IBoatSimulatorController;
import interfaces.ICommandHandler;
import utilities.Constants;

import java.util.List;

public class CommandHandler implements ICommandHandler {
    private IBoatSimulatorController controller;

    public CommandHandler(IBoatSimulatorController controller) {
        this.setController(controller);
    }

    private IBoatSimulatorController getController() {
        return this.controller;
    }

    private void setController(IBoatSimulatorController controller) {
        this.controller = controller;
    }

    public String ExecuteCommand(String name, List<String> parameters) throws DuplicateModelException, NonExistantModelException, RaceAlreadyExistsException, NoSetRaceException, InsufficientContestantsException {
        switch (name) {
            case "CreateBoatEngine":
                if (parameters.get(3).equals("Jet")) {
                    return this.getController().CreateBoatEngine(
                            parameters.get(0),
                            Integer.parseInt(parameters.get(1)),
                            Integer.parseInt(parameters.get(2)),
                            EngineType.valueOf("JET"));
                } else if (parameters.get(3).equals("Sterndrive")) {
                    return this.getController().CreateBoatEngine(
                            parameters.get(0),
                            Integer.parseInt(parameters.get(1)),
                            Integer.parseInt(parameters.get(2)),
                            EngineType.valueOf("STERNDRIVE"));
                }

                throw new IllegalArgumentException(Constants.IncorrectEngineTypeMessage);

            case "CreateRowBoat":
                return this.getController().CreateRowBoat(
                        parameters.get(0),
                        Integer.parseInt(parameters.get(1)),
                        Integer.parseInt(parameters.get(2)));
            case "CreateSailBoat":
                return this.getController().CreateSailBoat(
                        parameters.get(0),
                        Integer.parseInt(parameters.get(1)),
                        Integer.parseInt(parameters.get(2)));
            case "CreatePowerBoat":
                return this.getController().CreatePowerBoat(
                        parameters.get(0),
                        Integer.parseInt(parameters.get(1)),
                        parameters.get(2),
                        parameters.get(3));
            case "CreateYacht":
                return this.getController().CreateYacht(
                        parameters.get(0),
                        Integer.parseInt(parameters.get(1)),
                        parameters.get(2),
                        Integer.parseInt(parameters.get(3)));
            case "OpenRace":
                return this.getController().OpenRace(
                        Integer.parseInt(parameters.get(0)),
                        Integer.parseInt(parameters.get(1)),
                        Integer.parseInt(parameters.get(2)),
                        Boolean.parseBoolean(parameters.get(3)));
            case "SignUpBoat":
                return this.getController().SignUpBoat(parameters.get(0));
            case "StartRace":
                return this.getController().StartRace();
            case "GetStatistic":
                return this.getController().GetStatistic();
            default:
                throw new IllegalArgumentException();
        }
    }
}
