package hell.repository;

import hell.entities.items.CommonItem;
import hell.interfaces.Hero;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import hell.interfaces.Repository;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HeroRepository implements Repository {
    private static final String CREATED_S_S = "Created %s - %s";
    private static final String ADDED_ITEM_S_TO_HERO_S = "Added item - %s to Hero - %s";
    private static final String ADDED_RECIPE_S_TO_HERO_S = "Added recipe - %s to Hero - %s";

    private Map<String, Hero> heroes;
    private int COUNTER = 1;

    public HeroRepository() {
        this.heroes = new LinkedHashMap<>();
    }

    @Override
    public String heroCommand(Hero hero) {
        this.heroes.put(hero.getName(), hero);
        return String.format(CREATED_S_S, hero.getClass().getSimpleName(), hero.getName());
    }

    @Override
    public String itemCommand(CommonItem item, String heroName) {
        this.heroes.get(heroName).addItem(item);
        return String.format(ADDED_ITEM_S_TO_HERO_S, item.getName(), heroName);
    }

    @Override
    public String recipeCommand(Recipe recipe, String heroName) {
        this.heroes.get(heroName).addRecipe(recipe);
        return String.format(ADDED_RECIPE_S_TO_HERO_S, recipe.getName(), heroName);
    }

    @Override
    public String inspectCommand(String heroName) {
        return this.heroes.get(heroName).toString();
    }

    @Override
    public String quitCommand() throws IllegalAccessException {
        Comparator<? super Hero> comp = (Comparator<Hero>) (o1, o2) -> {
            long f_1 = o1.getStrength() + o1.getAgility() + o1.getIntelligence();
            long f_2 = o2.getStrength() + o2.getAgility() + o2.getIntelligence();
            if (Long.compare(f_2, f_1) == 0) {
                long s_1 = o1.getHitPoints() + o1.getDamage();
                long s_2 = o2.getHitPoints() + o2.getDamage();
                return Long.compare(s_2, s_1);
            }
            return Long.compare(f_2, f_1);
        };

        StringBuilder builder = new StringBuilder();
        List<Hero> collect = this.heroes.values().stream().sorted(comp).collect(Collectors.toList());
        for (Hero hero : collect) {
            builder
                    .append(String.format("%d. %s: %s", COUNTER++, hero.getClass().getSimpleName(), hero.getName())).append(System.lineSeparator())
                    .append(String.format("###HitPoints: %d", hero.getHitPoints())).append(System.lineSeparator())
                    .append(String.format("###Damage: %d", hero.getDamage())).append(System.lineSeparator())
                    .append(String.format("###Strength: %d", hero.getStrength())).append(System.lineSeparator())
                    .append(String.format("###Agility: %d", hero.getAgility())).append(System.lineSeparator())
                    .append(String.format("###Intelligence: %d", hero.getIntelligence())).append(System.lineSeparator())
                    .append(String.format("###Items: %s", hero.getItems().size() != 0 ? hero.getItems().stream().map(Item::getName).collect(Collectors.toList()).toString().replace("[", "").replace("]", "") : "None")).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
