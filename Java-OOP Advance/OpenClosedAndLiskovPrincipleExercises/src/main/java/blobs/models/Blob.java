package blobs.models;

import blobs.interfaces.Attack;
import blobs.interfaces.Behavior;

public class Blob {

    private static boolean SHOULD_PRINT_DETAILED_INFO = false;

    private String name;
    private int currentHealth;
    private int damage;
    private Behavior behavior;
    private Attack attack;
    private int initialHealth;

    public Blob(String name, int health, int damage, Behavior behavior, Attack attack) {
        this.name = name;
        this.currentHealth = health;
        this.damage = damage;
        this.behavior = behavior;
        this.attack = attack;

        this.initialHealth = health;
    }

    public void passTurn() {
        if (this.behavior.isTriggered()) {
            this.behavior.applyRecurrentEffect(this);
        }
    }

    private void triggerBehavior() {
        this.behavior.setIsTriggered(true);
        this.behavior.trigger(this);
    }

    public int getHealth() {
        return this.currentHealth;
    }

    public String getName() {
        return this.name;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int currentDamage) {
        this.damage = currentDamage;
    }

    public static void enableDetailedInfoPrint() {
        SHOULD_PRINT_DETAILED_INFO = true;
    }

    public static boolean isShouldPrintDetailedInfo() {
        return SHOULD_PRINT_DETAILED_INFO;
    }

    @Override
    public String toString() {
        if (this.getHealth() <= 0) {
            return String.format("Blob %s KILLED", this.getName());
        }

        return String.format("Blob %s: %s HP, %s Damage", this.getName(), this.getHealth(), this.getDamage());
    }

    public void setHealth(int health) {
        this.currentHealth = health;

        if (this.currentHealth < 0) {
            this.currentHealth = 0;
        }

        if (this.currentHealth <= this.initialHealth / 2 && !this.behavior.isTriggered()) {
            this.triggerBehavior();
        }
    }

    public void attack(Blob target) {
        this.attack.execute(this, target);
    }

    public void respond(int damage) {
        int currentHealth = this.getHealth();
        currentHealth -= damage;
        this.setHealth(currentHealth);
    }

    public Behavior getBehavior() {
        return this.behavior;
    }


}
