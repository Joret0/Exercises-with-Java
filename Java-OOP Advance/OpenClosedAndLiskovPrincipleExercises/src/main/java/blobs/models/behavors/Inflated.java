package blobs.models.behavors;

import blobs.models.Blob;

public class Inflated extends AbstractBehavior{

    private static final int INFLATED_DAMAGE_SUPPLY = 50;
    private static final int INFLATED_DAMAGE_DECREMENT = 10;

    public Inflated() {
        super();
    }

    @Override
    public void trigger(Blob source) {
        this.sourceInitialDamage = source.getDamage();
        super.setIsTriggered(true);
        this.applyTriggerEffect(source);
    }

    @Override
    public void applyRecurrentEffect(Blob source) {
        if (super.toDelayRecurrentEffect()) {
            super.setToDelayRecurrentEffect(false);
        } else {
            source.setHealth(source.getHealth() - INFLATED_DAMAGE_DECREMENT);
        }
    }

    public boolean toDelayRecurrentEffect() {
        return super.toDelayRecurrentEffect;
    }

    public void setToDelayRecurrentEffect(boolean toDelayRecurrentEffect) {
        super.toDelayRecurrentEffect = toDelayRecurrentEffect;
    }

    private void applyTriggerEffect(Blob source) {
        source.setHealth(source.getHealth() + INFLATED_DAMAGE_SUPPLY);
    }
}
