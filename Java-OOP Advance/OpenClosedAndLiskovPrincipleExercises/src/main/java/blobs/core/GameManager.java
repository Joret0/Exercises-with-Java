package blobs.core;

import blobs.factories.AttackFactory;
import blobs.factories.BehaviorFactory;
import blobs.factories.BlogFactory;
import blobs.models.Blob;

import java.util.Map;

public class GameManager {
    private Map<String, Blob> blobs;

    public GameManager(Map<String, Blob> blobs) {
        this.blobs = blobs;
    }

    public String status() {
        StringBuilder builder = new StringBuilder();
        for (Blob blob : blobs.values()) {
            builder.append(blob).append(System.lineSeparator());
        }
        this.pass();
        return builder.toString().trim();
    }

    public void create(String name, int health, int damage, String behavior, String attack) {
        Blob blob = BlogFactory.generateBlob(name, health, damage, BehaviorFactory.generateBehavior(behavior), AttackFactory.generateAttack(attack));
        this.blobs.put(blob.getName(), blob);

        this.pass();
    }

    public String attack(String attackerName, String targetName) {
        Blob target = this.blobs.get(targetName);
        Blob attacker = this.blobs.get(attackerName);
        attacker.attack(target);
        String returnStr = "";

        if (target.getBehavior().isTriggered() && Blob.isShouldPrintDetailedInfo()) {
            if (target.getHealth() <= 0) {
                returnStr = String.format("Blob %s was killed", target.getName());
            } else {
                returnStr = String.format("Blob %s toggled %s", target.getName(), target.getBehavior());
            }
        }

        this.pass();
        return returnStr;
    }

    public void pass() {
        for (Blob blob : blobs.values()) {
            blob.passTurn();
        }
    }

    public void enableReportEvents() {
        Blob.enableDetailedInfoPrint();
    }
}
