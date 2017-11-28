package Pr2CardRank;

public enum Cards {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

    public static void printValues() {
        System.out.println("Card Ranks:");
        for (Cards card : Cards.values()) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s", card.ordinal(), card.name()));
        }
    }
}
