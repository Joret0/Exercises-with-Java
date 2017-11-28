package Pr6InfernoInfinity.entities;

import Pr6InfernoInfinity.anotations.CustomAnnotation;

import java.util.Arrays;
import java.util.Objects;

@CustomAnnotation(author = "Pesho", description = "Used for Java OOP Advanced course - Enumerations and Annotations.",
        reviewers = {"Pesho", "Svetlio"}, revision = 3)
public class Weapon implements IWeapon{
    private String name;
    private WeaponType weaponType;
    private Gem[] gems;

    public Weapon(String name, WeaponType type) {
        this.name = name;
        this.weaponType = type;
        this.gems = new Gem[type.getSockets()];
    }

    @Override
    public void add(int index, Gem gemParam) {
        try {
            this.gems[index] = gemParam;
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    @Override
    public void remove(int index) {
        try {
            this.gems[index] = null;
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    @Override
    public String print() {
        return this.toString();
    }

    private int getAgilityBonusPoints() {
        return Arrays.stream(this.gems).filter(Objects::nonNull).mapToInt(Gem::getAgility).sum();
    }

    private int getStrengthBonusPoints() {
        return Arrays.stream(this.gems).filter(Objects::nonNull).mapToInt(Gem::getStrength).sum();
    }

    private int getVitalityBonusPoints() {
        return Arrays.stream(this.gems).filter(Objects::nonNull).mapToInt(Gem::getVitality).sum();
    }

    private int getTotalBonus(int m_1, int m_2) {
        int strengthBonus = Arrays.stream(this.gems).filter(Objects::nonNull).mapToInt(Gem::getStrength).sum() * m_1;
        int agilityBonus = Arrays.stream(this.gems).filter(Objects::nonNull).mapToInt(Gem::getAgility).sum() * m_2;

        return strengthBonus + agilityBonus;
    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.name, this.getTotalMinDamage(), this.getTotalMaxDamage(), this.getStrengthBonusPoints(),
                this.getAgilityBonusPoints(), this.getVitalityBonusPoints());
    }

    private int getTotalMinDamage() {
        return this.weaponType.getMin() + this.getTotalBonus(2, 1);
    }

    private int getTotalMaxDamage() {
        return this.weaponType.getMax() + this.getTotalBonus(3, 4);
    }

    private double calculateItemLevel() {
        double weaponPower = (this.getTotalMinDamage() + this.getTotalMaxDamage()) / 2.0;
        int bonusPower = this.getStrengthBonusPoints() + this.getAgilityBonusPoints() + this.getVitalityBonusPoints();
        return weaponPower + bonusPower;
    }

    @Override
    public int compareTo(Weapon o) {
        return Double.compare(this.calculateItemLevel(), o.calculateItemLevel());
    }

    public String getItemLevelFormattedOutput() {
        return this.toString().concat(String.format(" (Item Level: %.1f)", this.calculateItemLevel()));
    }
}
