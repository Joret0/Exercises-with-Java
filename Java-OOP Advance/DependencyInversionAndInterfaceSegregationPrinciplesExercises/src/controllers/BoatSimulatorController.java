package controllers;

import enumeration.EngineType;
import exeptions.*;
import interfaces.*;
import models.boats.PowerBoat;
import models.boats.RowBoat;
import models.boats.SailBoat;
import models.boats.Yacht;
import models.engines.JetEngine;
import models.engines.SterndriveEngine;
import models.race.Race;
import utilities.Constants;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BoatSimulatorController implements IBoatSimulatorController {
    private IDatabase database;
    private IRace currentIRace;

    public BoatSimulatorController(IDatabase database) {
        this.database = database;
    }


    @Override
    public String CreateBoatEngine(String model, int horsepower, int displacement, EngineType engineType)
            throws DuplicateModelException {
        EngineType type;
        try {
            type = engineType;
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IncorrectEngineTypeException(Constants.IncorrectEngineTypeMessage);
        }

        IEngine engine = null;
        switch (type) {
            case JET:
                engine = new JetEngine(model, horsepower, displacement);
                break;
            case STERNDRIVE:
                engine = new SterndriveEngine(model, horsepower, displacement);
                break;
        }

        this.database.getEngines().Add(engine);
        StringBuilder sb = new StringBuilder();
        sb.append("Engine model ").append(model).append(" with ").append(horsepower)
                .append(" HP and displacement ").append(displacement).append(" cm3 created successfully.");
        return sb.toString();
    }

    @Override
    public String CreateRowBoat(String model, int weight, int oars)
            throws DuplicateModelException {
        IBoat boat = new RowBoat(model, weight, oars);
        this.database.getBoats().Add(boat);
        StringBuilder sb = new StringBuilder();
        sb.append("Row boat with model ").append(model).append(" registered successfully.");
        return sb.toString();
    }

    @Override
    public String CreateSailBoat(String model, int weight, int sailEfficiency)
            throws DuplicateModelException {
        IBoat boat = new SailBoat(model, weight, sailEfficiency);
        this.database.getBoats().Add(boat);
        StringBuilder sb = new StringBuilder();
        sb.append("Sail boat with model ").append(model).append(" registered successfully.");
        return sb.toString();
    }

    @Override
    public String CreatePowerBoat(String model, int weight, String firstEngineModel, String secondEngineModel)
            throws NonExistantModelException, DuplicateModelException {
        IEngine firstEngine = this.database.getEngines().GetItem(firstEngineModel);
        IEngine secondEngine = this.database.getEngines().GetItem(secondEngineModel);
        IBoat boat = new PowerBoat(model, weight, firstEngine, secondEngine);
        this.database.getBoats().Add(boat);
        StringBuilder sb = new StringBuilder();
        sb.append("Power boat with model ").append(model).append(" registered successfully.");
        return sb.toString();
    }

    @Override
    public String CreateYacht(String model, int weight, String engineModel, int cargo)
            throws NonExistantModelException, DuplicateModelException {
        IEngine engine = this.database.getEngines().GetItem(engineModel);
        IBoat boat = new Yacht(model, weight, engine, cargo);
        this.database.getBoats().Add(boat);
        StringBuilder sb = new StringBuilder();
        sb.append("Yacht with model ").append(model).append(" registered successfully.");
        return sb.toString();
    }

    @Override
    public String OpenRace(int distance, int windSpeed, int oceanCurrentSpeed, Boolean allowsMotorboats)
            throws RaceAlreadyExistsException {
        if (this.currentIRace != null) {
            throw new RaceAlreadyExistsException(Constants.RaceAlreadyExistsMessage);
        }

        IRace IRace = new Race(distance, windSpeed, oceanCurrentSpeed, allowsMotorboats);
        this.currentIRace = IRace;
        StringBuilder sb = new StringBuilder();
        sb.append("A new race with distance ").append(distance).append(" meters, wind speed ")
                .append(windSpeed).append(" m/s and ocean current speed ").append(oceanCurrentSpeed)
                .append(" m/s has been set.");
        return sb.toString();
    }

    @Override
    public String SignUpBoat(String model)
            throws NonExistantModelException, DuplicateModelException, NoSetRaceException {
        if (this.currentIRace == null) {
            throw new NoSetRaceException(Constants.NoSetRaceMessage);
        }

        IBoat boat = this.database.getBoats().GetItem(model);
        if (!this.currentIRace.getAllowsMotorboats() && boat.hasEngine()) {
            throw new IllegalArgumentException(Constants.IncorrectBoatTypeMessage);
        }

        this.currentIRace.AddParticipant(boat);
        StringBuilder sb = new StringBuilder();
        sb.append("Boat with model ").append(model).append(" has signed up for the current Race.");
        return sb.toString();
    }

    @Override
    public String StartRace() throws InsufficientContestantsException, NoSetRaceException {
        if (this.currentIRace == null) {
            throw new NoSetRaceException(Constants.NoSetRaceMessage);
        }

        List<IBoat> participants = this.currentIRace.GetParticipants();
        if (participants.size() < 3) {
            throw new InsufficientContestantsException(Constants.InsufficientContestantsMessage);
        }

        Comparator<IBoat> bySpeedDescending = (b1, b2) -> {
            double s1 = b1.CalculateRaceSpeed(this.currentIRace);
            double s2 = b2.CalculateRaceSpeed(this.currentIRace);
            if (s1 < 0 && s2 < 0) {
                return 0;
            }
            return Double.compare(s2, s1);
        };
        List<IBoat> winners = participants.stream()
                .sorted(bySpeedDescending)
                .limit(3)
                .collect(Collectors.toList());

        StringBuilder result = new StringBuilder();
        int placeCounter = 1;
        for (IBoat winner : winners) {
            double speed = winner.CalculateRaceSpeed(this.currentIRace);
            double time = this.currentIRace.getDistance() / speed;
            result.append(placeCounter == 1 ? "First" : placeCounter == 2 ? "Second" : "Third")
                    .append(" place: ").append(winner.getClass().getSimpleName())
                    .append(" Model: ").append(winner.getModel())
                    .append(" Time: ").append(speed <= 0D ? "Did not finish!" : String.format("%.2f sec", time))
                    .append(System.lineSeparator());
            placeCounter++;
        }

        this.currentIRace = null;
        return result.toString().trim();
    }

    @Override
    public String GetStatistic() throws NoSetRaceException {
        if (this.currentIRace == null) {
            throw new NoSetRaceException(Constants.NoSetRaceMessage);
        }

        List<IBoat> participants = this.currentIRace.GetParticipants();
        Map<String, List<IBoat>> participantsByBoatType = participants.stream().collect(Collectors.groupingBy((p) -> p.getClass().getSimpleName()));
        int totalParticipants = participantsByBoatType.values().stream().mapToInt((p) -> p.size()).sum();

        StringBuilder sb = new StringBuilder();
        participantsByBoatType.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach((e) -> {
                    sb.append(String.format("%s -> %.2f", e.getKey(), 100D * e.getValue().size() / totalParticipants));
                    sb.append("%").append(System.lineSeparator());
                });
        return sb.toString().trim();
    }
}
