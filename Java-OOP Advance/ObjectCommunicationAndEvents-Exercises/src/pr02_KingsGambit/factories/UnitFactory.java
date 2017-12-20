package pr02_KingsGambit.factories;

import pr02_KingsGambit.enums.UnitType;
import pr02_KingsGambit.models.Footman;
import pr02_KingsGambit.models.RoyalGuard;
import pr02_KingsGambit.models.Unit;

public class UnitFactory {
    public static Unit create(UnitType type, String unitName) {
        switch (type) {
            case FOOTMAN:
                return new Footman(unitName);
            case GUARD:
                return new RoyalGuard(unitName);
        }
        return null;
    }
}
