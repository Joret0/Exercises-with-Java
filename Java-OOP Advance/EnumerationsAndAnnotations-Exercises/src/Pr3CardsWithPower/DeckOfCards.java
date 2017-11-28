package Pr3CardsWithPower;

public class DeckOfCards {
    public static void printDeckOfCards() {
        SuitPower[] suitPowers = SuitPower.values();
        RankPower[] rankPowers = RankPower.values();
        for (SuitPower suit : suitPowers) {
            for (RankPower rank : rankPowers) {
                System.out.printf("%s of %s%n", rank, suit);
            }
        }
    }
}
