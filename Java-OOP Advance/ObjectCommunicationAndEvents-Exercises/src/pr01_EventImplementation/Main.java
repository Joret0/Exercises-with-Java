package pr01_EventImplementation;

import pr01_EventImplementation.engines.Engine;
import pr01_EventImplementation.models.Dispatcher;
import pr01_EventImplementation.models.Handler;

public class Main {
    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher("initial");
        Handler handler = new Handler();
        dispatcher.addNameChangeListener(handler);
        Engine engine = new Engine(dispatcher);
        engine.run();
    }
}
