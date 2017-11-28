package Pr4CardWithPower.CardGame.core;

import Pr4CardWithPower.Card;
import Pr4CardWithPower.CardGame.io.ConsoleOutputWriter;
import Pr4CardWithPower.CardGame.utils.Constants;
import Pr4CardWithPower.RankPowers;
import Pr4CardWithPower.SuitPowers;

import java.util.*;

public class GameManager {
    private final int MAX_SIZE = 5;

    private ConsoleOutputWriter outputWriter;

    private Map<String, List<Card>> firstPlayerCards;
    private Map<String, List<Card>> secondPlayerCards;

    private String firstPlayerName;
    private String secondPlayerName;

    private List<Card> deck;

    public GameManager() {
        this.outputWriter = new ConsoleOutputWriter();
        this.firstPlayerCards = new HashMap<>();
        this.secondPlayerCards = new HashMap<>();
        this.deck = new ArrayList<>();
        this.initializeDeck();
    }

    private void initializeDeck() {
        for (SuitPowers suit : SuitPowers.values()) {
            for (RankPowers rank : RankPowers.values()) {
                Card card = new Card(rank.name(), suit.name());
                this.deck.add(card);
            }
        }
    }

    public void addFirstPlayer(String playerName) {
        this.firstPlayerCards.put(playerName, new ArrayList<>());
        this.firstPlayerName = playerName;
    }

    public void addSecondPlayer(String playerName) {
        this.secondPlayerCards.put(playerName, new ArrayList<>());
        this.secondPlayerName = playerName;
    }

    public boolean addCardToPlayer(String suit, String rank) {
        try {
            Card card = new Card(suit, rank);
            String isAddedToPlayer_1 = tryAddToFirstPlayer(card);
            String isAddedToPlayer_2 = "";
            if (isAddedToPlayer_1.equals(Constants.LIMIT_REACHED)) {
                isAddedToPlayer_2 = tryAddToSecondPlayer(card);
                if (isAddedToPlayer_2.equals(Constants.LIMIT_REACHED)) {
                    return true;
                }
            }

            if (isAddedToPlayer_1.equals(Constants.CARD_NOT_FOUND)) {
                System.out.println(Constants.CARD_NOT_FOUND);
            }
        } catch (IllegalArgumentException iae) {
            ConsoleOutputWriter.writeLine(Constants.NO_SUCH_CARD);
            return false;
        }

        return false;
    }

    private String tryAddToSecondPlayer(Card card) {
        if (!this.deck.contains(card)) {
            return Constants.CARD_NOT_FOUND;
        }

        this.deck.remove(card);
        this.secondPlayerCards.get(this.secondPlayerName).add(card);

        if (this.secondPlayerCards.get(this.secondPlayerName).size() == MAX_SIZE) {
            return Constants.LIMIT_REACHED;
        }

        return Constants.CARD_ADDED;
    }

    private String tryAddToFirstPlayer(Card card) {
        if (!this.deck.contains(card)) {
            return Constants.CARD_NOT_FOUND;
        }
        if (this.firstPlayerCards.get(this.firstPlayerName).size() == MAX_SIZE) {
            return Constants.LIMIT_REACHED;
        }

        this.deck.remove(card);
        this.firstPlayerCards.get(this.firstPlayerName).add(card);
        return Constants.CARD_ADDED;
    }

    public void printWinner() {
        System.out.println(String.format("%s wins with %s", this.getWinnerName(), this.getBestCard()));
    }

    private Card getBestCard() {
        Card strongest_1 = this.getStrongestCardFromDeck(this.firstPlayerCards.get(this.firstPlayerName));
        Card strongest_2 = this.getStrongestCardFromDeck(this.secondPlayerCards.get(this.secondPlayerName));

        return strongest_1.compareTo(strongest_2) > 0 ? strongest_1 : strongest_2;
    }

    private String getWinnerName() {
        Card strongest_1 = this.getStrongestCardFromDeck(this.firstPlayerCards.get(this.firstPlayerName));
        Card strongest_2 = this.getStrongestCardFromDeck(this.secondPlayerCards.get(this.secondPlayerName));

        return strongest_1.compareTo(strongest_2) > 0 ? this.firstPlayerName : this.secondPlayerName;
    }

    private Card getStrongestCardFromDeck(List<Card> cards) {
        cards.sort(Comparator.reverseOrder());
        return cards.get(0);
    }
}
