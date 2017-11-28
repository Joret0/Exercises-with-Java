package Pr4CardWithPower;

public class Card implements Comparable<Card>{
    private RankPowers rank;
    private SuitPowers suit;

    public Card(String rank, String suit) {
        this.initializeData(rank, suit);
    }

    private void initializeData(String rank, String suit) {
        this.setRank(rank);
        this.setSuit(suit);
    }

    private void setRank(String rank) {
        this.rank = RankPowers.valueOf(rank);
    }

    private void setSuit(String suit) {
        this.suit = SuitPowers.valueOf(suit);
    }

    public RankPowers getRank() {
        return rank;
    }

    public SuitPowers getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return String.format("%s of %s.", this.rank.name(), this.suit.name());
     /*   return String.format("Card name: %s of %s; Card power: %d", this.rank.name(), this.suit.name(),
                this.calculateTotalPower());*/
    }

    private int calculateTotalPower() {
        return this.rank.getPower() + this.suit.getPower();
    }


    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.calculateTotalPower(), o.calculateTotalPower());
    }

    @Override
    public int hashCode() {
        int hashCode = 1;

        hashCode = hashCode * 37 + this.rank.hashCode();
        hashCode = hashCode * 37 + this.suit.hashCode();

        return hashCode;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Card)) {
            return false;
        }

        Card that = (Card) other;

        // Custom equality check here.
        return this.rank.equals(that.rank) && this.suit.equals(that.suit);
    }
}
