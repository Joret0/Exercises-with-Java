package hell.factories;

import hell.entities.heroes.Assassin;
import hell.entities.heroes.Barbarian;
import hell.entities.heroes.Wizard;
import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Hero;

public class HeroFactory {
    public static Hero create(String type, String name) {
        switch (type) {
            case "Barbarian":
                return new Barbarian(name, new HeroInventory());
            case "Assassin":
                return new Assassin(name, new HeroInventory());
            case "Wizard":
                return new Wizard(name, new HeroInventory());
            default:
                return null;
        }
    }
}
