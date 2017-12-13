package blobs.factories;

import blobs.interfaces.Behavior;
import blobs.models.behavors.Aggressive;
import blobs.models.behavors.Inflated;

public class BehaviorFactory {
    public static Behavior generateBehavior(String type) {
        if (type.equals("Inflated")) {
            return new Inflated();
        } else if (type.equals("Aggressive")) {
            return new Aggressive();
        }
        return null;
    }
}
