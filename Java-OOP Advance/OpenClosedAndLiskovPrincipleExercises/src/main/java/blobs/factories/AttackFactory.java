package blobs.factories;

import blobs.interfaces.Attack;
import blobs.models.attacks.Blobplode;
import blobs.models.attacks.PutridFart;

public class AttackFactory {
    public static Attack generateAttack(String type) {
        if (type.equals("Blobplode")) {
            return new Blobplode();
        } else if (type.equals("PutridFart")) {
            return new PutridFart();
        }
        return null;
    }
}
