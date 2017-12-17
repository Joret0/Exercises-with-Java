package interfaces;

import exeptions.DuplicateModelException;

import java.util.List;

public interface IRace {
    int getDistance();
    int getWindSpeed();
    int getOceanCurrentSpeed();

    boolean getAllowsMotorboats();

    void AddParticipant(IBoat boat) throws DuplicateModelException;

    List<IBoat> GetParticipants();
}
