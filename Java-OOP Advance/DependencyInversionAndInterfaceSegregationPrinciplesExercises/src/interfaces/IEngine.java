package interfaces;

public interface IEngine extends IModelable{
    int getHorsepower();

    int getDisplacement();

    int getOutput();

    int getCachedOutput();
}
