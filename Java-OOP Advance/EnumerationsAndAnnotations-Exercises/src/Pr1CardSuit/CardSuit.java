package Pr1CardSuit;

public enum CardSuit {
    CLUBS, DIAMONDS, HEARTS, SPADES;

    public static void printValues() {
        System.out.println("Card Suits:");
        for (CardSuit enumConstant :CardSuit.values()){
            System.out.println(String.format("Ordinal value: %d; Name value: %s", enumConstant.ordinal(), enumConstant.name()));
        }
    }
}
