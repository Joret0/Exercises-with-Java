package blobs.models.behavors;

import blobs.interfaces.Behavior;
import blobs.models.Blob;

public abstract class AbstractBehavior implements Behavior{
    private static final String BEHAVIOUR_STRING = "Behavior";
    private boolean isTriggered;
    boolean toDelayRecurrentEffect;
    int sourceInitialDamage;

    AbstractBehavior() {
        this.toDelayRecurrentEffect = true;
    }

    public boolean isTriggered() {
        return this.isTriggered;
    }

    public void setIsTriggered(boolean isTriggered) {
        this.isTriggered = isTriggered;
    }

    public boolean toDelayRecurrentEffect() {
        return this.toDelayRecurrentEffect;
    }

    public void setToDelayRecurrentEffect(boolean toDelayRecurrentEffect) {
        this.toDelayRecurrentEffect = toDelayRecurrentEffect;
    }

    public abstract void trigger(Blob source);
    public abstract void applyRecurrentEffect(Blob source);

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + BEHAVIOUR_STRING;
    }
}
