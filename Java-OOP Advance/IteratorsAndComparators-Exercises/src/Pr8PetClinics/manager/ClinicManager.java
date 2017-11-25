package Pr8PetClinics.manager;

import Pr8PetClinics.entities.Clinic;
import Pr8PetClinics.entities.Pet;
import Pr8PetClinics.factories.ClinicFactory;
import Pr8PetClinics.factories.PetFactory;

import java.util.HashMap;
import java.util.Map;

public class ClinicManager {
    private ClinicFactory clinicsFactory;
    private PetFactory petFactory;
    private Map<String, Clinic> clinics;
    private Map<String, Pet> pets;

    public ClinicManager() {
        this.clinicsFactory = new ClinicFactory();
        this.petFactory = new PetFactory();
        this.clinics = new HashMap<>();
        this.pets = new HashMap<>();
    }

    public String createClinic(String clinicName, int roomsCount) {
        try {
            this.clinics.put(clinicName, clinicsFactory.createClinic(clinicName, roomsCount));
            return "";
        } catch (IllegalArgumentException iae) {
            return iae.getMessage();
        }
    }

    public void createPet(String name, int age, String kind) {
        this.pets.put(name, petFactory.createPet(name, age, kind));
    }

    public boolean add(String petsName, String clinicsName) {
        return this.clinics.get(clinicsName).addPet(this.pets.get(petsName));
    }

    public boolean release(String clinicsName) {
        return this.clinics.get(clinicsName).releasePet();
    }

    public boolean hasEmptyRooms(String clinicsName) {
        return this.clinics.get(clinicsName).hasEmptyRooms();
    }

    public String printClinic(String clinicsName) {
        return this.clinics.get(clinicsName).printRooms();
    }

    public String printClinicsRoom(String clinicsName, int room) {
        return this.clinics.get(clinicsName).printRooms(room);
    }
}
