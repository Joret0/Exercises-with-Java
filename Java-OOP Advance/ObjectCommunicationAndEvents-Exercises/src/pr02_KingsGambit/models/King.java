package pr02_KingsGambit.models;

import pr02_KingsGambit.interfaces.Attackable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class King implements Attackable{
    private static final String KING_S_IS_UNDER_ATTACK = "King %s is under attack!";
    private static final String ROYAL_GUARD_TYPE = "RoyalGuard";
    private static final String FOOTMAN_TYPE = "Footman";

    private Map<String, Unit> lieges;
    private String name;

    public King(String name) {
        this.name = name;
        this.lieges = new LinkedHashMap<>();
    }

    public void addLiege(String name, Unit unit) {
        this.lieges.put(name, unit);
    }

    @Override
    public void respond() {
        System.out.println(String.format(KING_S_IS_UNDER_ATTACK, this.name));
        this.lieges.values().stream().filter(x -> x.getClass().getSimpleName().equals(ROYAL_GUARD_TYPE) && !x.isDead).forEach(System.out::println);
        this.lieges.values().stream().filter(x -> x.getClass().getSimpleName().equals(FOOTMAN_TYPE) && !x.isDead).forEach(System.out::println);
    }

    public Map<String, Unit> getLieges() {
        return this.lieges;
    }

    public void removeDeathUnits() {
        this.lieges = this.lieges.entrySet().stream().filter(x -> !x.getValue().isDead)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }
}
