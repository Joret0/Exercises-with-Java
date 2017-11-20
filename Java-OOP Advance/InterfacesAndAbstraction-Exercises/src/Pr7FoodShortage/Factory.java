package Pr7FoodShortage;


public class Factory {

    public static Buyer createBuyer(String[] input) {
        Buyer buyer = null;

        switch (input.length) {
            case 3:
                buyer = new Rebel(input[0], Integer.parseInt(input[1]), input[2]);
                break;
            case 4:
                buyer = new Citizen(input[0], Integer.parseInt(input[1]), input[2], input[3]);
                break;
        }
        return buyer;
    }
}
