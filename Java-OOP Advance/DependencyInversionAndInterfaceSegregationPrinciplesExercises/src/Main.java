import controllers.BoatSimulatorController;
import core.CommandHandler;
import core.Engine;
import database.BoatSimulatorDatabase;
import interfaces.IBoatSimulatorController;
import interfaces.ICommandHandler;
import interfaces.IDatabase;

public class Main {
    public static void main(String[] args) {
        IDatabase db = new BoatSimulatorDatabase();
        IBoatSimulatorController ctrl = new BoatSimulatorController(db);
        ICommandHandler commandHandler = new CommandHandler(ctrl);
        Engine engine = new Engine(commandHandler);
        engine.run();
    }
}
