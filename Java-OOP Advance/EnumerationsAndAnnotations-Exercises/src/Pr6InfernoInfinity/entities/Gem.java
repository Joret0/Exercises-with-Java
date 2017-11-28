package Pr6InfernoInfinity.entities;

public enum Gem {
    RUBY(7, 2, 5), EMERALD(1, 4, 9), AMETHYST(2, 8, 4);

    private int strength;
    private int agility;
    private int vitality;

    Gem() {
    }

    Gem(int strength, int agility, int vitality) {
        this.strength = strength;
        this.agility = agility;
        this.vitality = vitality;
    }

    public void setStrength(int strength) {
        this.strength += strength;
    }

    public void setAgility(int agility) {
        this.agility += agility;
    }

    public void setVitality(int vitality) {
        this.vitality += vitality;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getVitality() {
        return vitality;
    }

    @Override
    public String toString() {
        return String.format("+%d Strength, +%d Agility, +%d Vitality", this.strength, this.agility, this.vitality);
    }
}
