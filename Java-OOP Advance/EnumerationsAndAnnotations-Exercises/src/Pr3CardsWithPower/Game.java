package Pr3CardsWithPower;

public class Game {
    private Player firstPlayer;
    private Player secondPlayer;

    public Game(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public Player getFirstPlayer() {
        return this.firstPlayer;
    }

    public Player getSecondPlayer() {
        return this.secondPlayer;
    }

    public void addCardToFirstPlayer(Card card) {
        boolean hasInDeck = true;
        for (Card card1 : this.firstPlayer.getCards()) {
            if (card.compareTo(card1) == 0) {
                System.out.println("Card is not in the deck.");
                hasInDeck = false;
                break;
            }
        }
        if (hasInDeck) {
            this.firstPlayer.getCards().add(card);
        }
    }

    public void addCardToSecondPlayer(Card card) {
        boolean hasInDeck = true;
        for (Card card1 : this.firstPlayer.getCards()) {
            if (card.compareTo(card1) == 0) {
                System.out.println("Card is not in the deck.");
                hasInDeck = false;
                break;
            }
        }
        for (Card card1 : this.secondPlayer.getCards()) {
            if (card.compareTo(card1) == 0) {
                System.out.println("Card is not in the deck.");
                hasInDeck = false;
                break;
            }
        }
        if (hasInDeck) {
            this.secondPlayer.getCards().add(card);
        }
    }

    public Player getWinner() {
        if (this.firstPlayer.getHighestCard().compareTo(this.secondPlayer.getHighestCard()) > 0) {
            return this.firstPlayer;
        } else if (this.firstPlayer.getHighestCard().compareTo(this.secondPlayer.getHighestCard()) < 0) {
            return this.secondPlayer;
        } else {
            return null;
        }
    }
    @Override
    public String toString() {
        return String.format("%s wins with %s of %s.",
                this.getWinner().getName(),
                this.getWinner().getHighestCard().getRankPower().name(),
                this.getWinner().getHighestCard().getSuitPower().name());
    }
}
