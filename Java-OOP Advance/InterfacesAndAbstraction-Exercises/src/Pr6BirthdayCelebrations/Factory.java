package Pr6BirthdayCelebrations;

public class Factory {

    public static Inhabitable createInhabitant(String[] input) {

        Inhabitable inhabitant = null;
        switch (input[0].toLowerCase()) {
            case "citizen":
                inhabitant = new Citizen(input[1], Integer.parseInt(input[2]), input[3], input[4]);
                break;
            case "robot":
                inhabitant = new Robot(input[1], input[2]);
                break;
            case "pet":
                inhabitant = new Pet(input[1], input[2]);
                break;
        }
        return inhabitant;
    }
}
