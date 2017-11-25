package Pr8PetClinics.factories;

import Pr8PetClinics.entities.Pet;

public class PetFactory {
    public Pet createPet(String name, int age, String kind) {
        return new Pet(name, age, kind);
    }
}
