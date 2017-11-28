package Pr6InfernoInfinity.core;

import Pr6InfernoInfinity.anotations.CustomAnnotation;
import Pr6InfernoInfinity.entities.Gem;
import Pr6InfernoInfinity.entities.Weapon;
import Pr6InfernoInfinity.factory.WeaponFactory;
import Pr6InfernoInfinity.utilities.Constants;

import java.util.LinkedHashMap;
import java.util.Map;

public class GameManager {
    private Map<String, Weapon> weapons;

    public GameManager() {
        this.weapons = new LinkedHashMap<>();
    }

    public void create(String weaponType, String weaponName) {
        this.weapons.put(weaponName, WeaponFactory.createWeapon(weaponType,weaponName));
    }

    public void add(String weaponName, int index, String gemType) {
        this.weapons.get(weaponName).add(index, Gem.valueOf(gemType));
    }

    public void remove(String weaponName, int index) {
        this.weapons.get(weaponName).remove(index);
    }

    public String print(String weaponName) {
        return this.weapons.get(weaponName).print();
    }

    public String compare(String firstWeaponName, String secondWeaponName) {
        int compResult = this.weapons.get(firstWeaponName).compareTo(this.weapons.get(secondWeaponName));
        if (compResult >= 0) {
            return this.weapons.get(firstWeaponName).getItemLevelFormattedOutput();
        }
        return this.weapons.get(secondWeaponName).getItemLevelFormattedOutput();
    }

    public String printAuthor() {
        return Constants.AUTHOR + Weapon.class.getAnnotation(CustomAnnotation.class).author();
    }

    public String printRevision() {
        return Constants.REVISION + Weapon.class.getAnnotation(CustomAnnotation.class).revision();
    }

    public String printDescription() {
        return Constants.DESCRIPTION + Weapon.class.getAnnotation(CustomAnnotation.class).description();
    }

    public String printReviewers() {
        return Constants.REVIEWERS + String.join(", ", Weapon.class.getAnnotation(CustomAnnotation.class).reviewers());
    }
}
