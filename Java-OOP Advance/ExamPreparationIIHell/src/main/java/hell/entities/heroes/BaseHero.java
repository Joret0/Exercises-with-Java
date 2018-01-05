package hell.entities.heroes;

import hell.entities.miscellaneous.HeroInventory;
import hell.entities.miscellaneous.ItemCollection;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

public abstract class BaseHero implements Hero {
    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int hitPoints;
    private int damage;
    private Inventory inventory;

    protected BaseHero(String name, int strength, int agility, int intelligence, int hitPoints, int damage, Inventory inventory) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory = inventory;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Hero: %s, Class: %s", this.getName(), this.getClass().getSimpleName())).append(System.lineSeparator());
        builder.append(String.format("HitPoints: %d, Damage: %d", this.getHitPoints(), this.getDamage())).append(System.lineSeparator());
        builder.append(String.format("Strength: %d", this.getStrength())).append(System.lineSeparator());
        builder.append(String.format("Agility: %d", this.getAgility())).append(System.lineSeparator());
        builder.append(String.format("Intelligence: %d", this.getIntelligence())).append(System.lineSeparator());

        Collection<Item> items = this.getItems();
        if (items.isEmpty()) {
            builder.append("Items: None");
        } else {
            builder.append("Items:").append(System.lineSeparator());
            items.forEach(x -> builder.append(x.toString()));
        }

        return builder.toString().trim();
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.strength + this.inventory.getTotalStrengthBonus();
    }

    @Override
    public long getAgility() {
        return this.agility + this.inventory.getTotalAgilityBonus();
    }

    @Override
    public long getIntelligence() {
        return this.intelligence + this.inventory.getTotalIntelligenceBonus();
    }

    @Override
    public long getHitPoints() {
        return this.hitPoints + this.inventory.getTotalHitPointsBonus();
    }

    @Override
    public long getDamage() {
        return this.damage + this.inventory.getTotalDamageBonus();
    }

    @Override
    public Collection<Item> getItems()  {
        for (Field field : HeroInventory.class.getDeclaredFields()) {
            if (field.isAnnotationPresent(ItemCollection.class)) {
                field.setAccessible(true);
                try {
                    return ((Map<String, Item>) field.get(this.inventory)).values();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public void addItem(Item item) {
        this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }
}
