package blobs.factories;

import blobs.interfaces.Attack;
import blobs.interfaces.Behavior;
import blobs.models.Blob;

public class BlogFactory {
    public static Blob generateBlob(String name, int health, int damage, Behavior behavior, Attack attack) {
        return new Blob(name, health, damage, behavior, attack);
    }
}
