package interfaces;

public interface IDatabase {
    IRepository<IBoat> getBoats();

    IRepository<IEngine> getEngines();
}
