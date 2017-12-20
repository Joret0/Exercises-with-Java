package pr02_KingsGambit.factories;

import pr02_KingsGambit.models.King;

public class KingFactory {
    public static King create(String unitName) {
        return new King(unitName);
    }
}
