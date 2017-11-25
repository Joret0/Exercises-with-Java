package Pr8PetClinics.entities;

import Pr8PetClinics.utilities.Constants;

import java.util.Arrays;
import java.util.Objects;

public class Clinic {
    private Pet[] pets;
    private int rooms;
    private String name;

    public Clinic(String name, int rooms) {
        this.name = name;
        this.setRooms(rooms);
        this.pets = new Pet[rooms];
    }

    public boolean addPet(Pet p) {
        int addSubstractValue = 1;
        boolean add = false;
        int start = this.rooms / 2;
       /* if (this.rooms != 0) {
            start = this.rooms / 2 + 1;
        }*/

        while (true) {
            if (start > this.rooms || start < 0) {
                return false;
            }
            if (this.pets[start] == null) {
                this.pets[start] = p;
//                this.pets.add(start, p);
                return true;
            }

            if (!add) {
                start -= addSubstractValue++;
                add = true;
            } else {
                start += addSubstractValue++;
                add = false;
            }
        }
    }

    public boolean releasePet() {
        int index = this.rooms / 2 + 1;
        int counter = 0;

        while (true) {
            if (index > this.rooms) {
                index = 0;
            }
            if (counter == this.rooms) {
                return false;
            }

            if (this.pets[index - 1] != null) {
                this.pets[index - 1] = null;
                return true;
            }
            counter++;
            index++;
        }
    }


    public boolean hasEmptyRooms() {
//        return this.rooms - this.pets.length == 0;
        return Arrays.stream(this.pets).filter(Objects::isNull).count() != 0;
//        return this.pets.stream().filter(Objects::isNull).count() != 0;
    }

    public String printRooms(int room) {
        try {
            return this.pets[room - 1].toString();
        } catch (NullPointerException npe) {
            return Constants.EMPTY_ROOM_MESSAGE;
        }
    }

    //SETTERS
    private void setRooms(int rooms) {
        if (rooms % 2 == 0) {
            throw new IllegalArgumentException(Constants.INVALID_ROOMS_COUNT);
        }
        this.rooms = rooms;
    }

    //    GETTERS
    public Pet[] getPets() {
        return pets;
    }

    public String printRooms() {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= this.rooms; i++) {
            builder.append(this.printRooms(i)).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
