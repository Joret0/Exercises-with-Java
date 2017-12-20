package pr02_KingsGambit.core;

import pr02_KingsGambit.enums.UnitType;
import pr02_KingsGambit.factories.KingFactory;
import pr02_KingsGambit.factories.UnitFactory;
import pr02_KingsGambit.models.King;

import java.util.List;

public class Kingdom {
    private King king;

    public Kingdom(String kingName, List<String> guardNames, List<String> footmanNames) {
        this.initializeData(kingName, guardNames, footmanNames);
    }

    private void initializeData(String kingName, List<String> guardNames, List<String> footmanNames) {
        this.king = KingFactory.create(kingName);
        guardNames.forEach(g -> king.addLiege(g, UnitFactory.create(UnitType.GUARD, g)));
        footmanNames.forEach(g -> king.addLiege(g, UnitFactory.create(UnitType.FOOTMAN, g)));
    }

    public void respondToAttack() {
        this.king.respond();
    }

    public void killUnit(String name) {
        this.king.getLieges().get(name).kill();
    }
}
