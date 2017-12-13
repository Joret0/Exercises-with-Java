package blobs.models.attacks;

import blobs.models.Blob;

public class Blobplode extends AbstractAttack{
    private static final int DAMAGE_MULTIPLIER = 2;

    @Override
    public void execute(Blob source, Blob target) {
        source.setHealth(source.getHealth() - source.getHealth() / 2);
        target.respond(source.getDamage() * DAMAGE_MULTIPLIER);
    }
}
