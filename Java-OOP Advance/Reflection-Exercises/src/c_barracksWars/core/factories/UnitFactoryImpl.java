package c_barracksWars.core.factories;

import c_barracksWars.contracts.Unit;
import c_barracksWars.contracts.UnitFactory;
import c_barracksWars.models.units.*;

public class UnitFactoryImpl implements UnitFactory{

    private static final String UNITS_PACKAGE_NAME =
            "c_barracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) {
        switch (unitType) {
            case "Archer":
                return new Archer();
            case "Gunner":
                return new Gunner();
            case "Horseman":
                return new Horseman();
            case "Pikeman":
                return new Pikeman();
            default:
                return new Swordsman();
        }
    }
}
