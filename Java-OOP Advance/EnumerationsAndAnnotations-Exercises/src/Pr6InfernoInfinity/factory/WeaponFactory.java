package Pr6InfernoInfinity.factory;

import Pr6InfernoInfinity.entities.Weapon;
import Pr6InfernoInfinity.entities.WeaponType;

public final class WeaponFactory {
    public static Weapon createWeapon(String weaponType, String weaponName) {
        return new Weapon(weaponName, WeaponType.valueOf(weaponType));
    }
}
