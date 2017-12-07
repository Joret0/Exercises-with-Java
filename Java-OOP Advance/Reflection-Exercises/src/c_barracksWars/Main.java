package c_barracksWars;

import c_barracksWars.contracts.Repository;
import c_barracksWars.contracts.Runnable;
import c_barracksWars.contracts.UnitFactory;
import c_barracksWars.core.Engine;
import c_barracksWars.core.factories.UnitFactoryImpl;
import c_barracksWars.data.UnitRepository;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();
        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
