package Pr8PetClinics.factories;

import Pr8PetClinics.entities.Clinic;

public class ClinicFactory {
    public Clinic createClinic(String name, int rooms) {
        return new Clinic(name, rooms);
    }
}
