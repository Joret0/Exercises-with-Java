package Pr3CardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String rank = reader.readLine();
//        String suit = reader.readLine();
//        Card card = new Card(rank, suit);
//        rank = reader.readLine();
//        suit = reader.readLine();
//        Card card2 = new Card(rank, suit);
//        if (card.compareTo(card2) > 0) {
//            System.out.println(card);
//        } else {
//            System.out.println(card2);
//        }

        //task_6();
        //task_7();
        task_8();
    }

    private static void task_8() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstPlayerName = reader.readLine();
        String secondPlayerName = reader.readLine();
        Player firstPlayer = new Player(firstPlayerName);
        Player secondPlayer = new Player(secondPlayerName);
        Game game = new Game(firstPlayer, secondPlayer);
        int index = 0;
        while (index < 11) {
            String[] line = reader.readLine().split(" of ");
            try {
                Card card = new Card(line[0], line[1]);
                if (index < 6) {
                    game.addCardToFirstPlayer(card);
                    index++;
                } else if (index > 5 && index < 11) {
                    game.addCardToSecondPlayer(card);
                    index++;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("No such card exists.");
            }
        }
        System.out.println(game);
    }

    private static void task_7() {
        DeckOfCards.printDeckOfCards();
    }

    private static void task_6() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        switch (line) {
            case "Rank":
                CustomEnumAnnotation annotation = RankPower.class.getAnnotation(CustomEnumAnnotation.class);
                System.out.printf("Type = %s, Description = %s%n", annotation.type(), annotation.description());
                break;
            case "Suit":
                CustomEnumAnnotation annotation2 = SuitPower.class.getAnnotation(CustomEnumAnnotation.class);
                System.out.printf("Type = %s, Description = %s", annotation2.type(), annotation2.description());
                break;
        }
    }
}
