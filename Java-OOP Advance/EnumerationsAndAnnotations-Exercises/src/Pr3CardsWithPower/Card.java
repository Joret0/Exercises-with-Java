package Pr3CardsWithPower;

public class Card implements Comparable<Card>{

    private RankPower rankPower;
    private SuitPower suitPower;

    public Card(String rankPower, String suitPower) {
        this.setRankPower(rankPower);
        this.setSuitPower(suitPower);
    }

    public RankPower getRankPower() {
        return this.rankPower;
    }

    public void setRankPower(String rankPower) {
        this.rankPower = RankPower.valueOf(rankPower.toUpperCase());
    }

    public SuitPower getSuitPower() {
        return this.suitPower;
    }

    public void setSuitPower(String suitPower) {
        this.suitPower = SuitPower.valueOf(suitPower.toUpperCase());
    }

    private int calculatePower() {
        return this.rankPower.getPower() + this.suitPower.getPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",
                this.rankPower.name(), this.suitPower.name(), this.calculatePower());
    }

    @Override
    public int compareTo(Card card) {
        return Integer.compare(this.calculatePower(), card.calculatePower());
    }
}
