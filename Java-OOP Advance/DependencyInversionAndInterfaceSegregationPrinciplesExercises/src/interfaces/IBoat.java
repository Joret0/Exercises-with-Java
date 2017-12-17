package interfaces;

public interface IBoat extends IModelable{
    int getWeight();

    double CalculateRaceSpeed(IRace race);

    boolean hasEngine();
}
