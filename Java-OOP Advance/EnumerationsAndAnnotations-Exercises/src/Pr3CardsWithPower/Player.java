package Pr3CardsWithPower;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> cards;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
    public Card getHighestCard() {
        Card card = this.cards.get(0);
        for (Card card1 : cards) {
            if (card.compareTo(card1) < 0) {
                card = card1;
            }
        }
        return card;
    }
}
