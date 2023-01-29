package pk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Player {
    private Dice dice;
    private int points = 0;
    private int wins = 0;
    private ArrayList<Card> cards;

    public Player(Dice dice, ArrayList<Card> cards) {
        this.dice = dice;
        this.cards = cards;
    }

    public int getWins() {
        return wins;
    }

    public Boolean won() {
        return points >= 1000;
    }

    public void addPoints(ArrayList<Faces> rolls, Card card) {
        int skulls = 0;
        for (Faces j : rolls) {
            if (j == Faces.SKULL) {
                skulls += 1;
                if (skulls >= 3) {
                    return;
                }
            }
        }

        for (int k = 0; k < 8; k++) {
            if (rolls.get(k) == Faces.DIAMOND || rolls.get(k) == Faces.GOLD) {
                points += 100;
            }
            int kindCount = 1;

            for (int p = k + 1; p < 8; p++) {
                if (rolls.get(k) == rolls.get(p)) {
                    kindCount++;
                }
            }
            if (kindCount == 8) {
                points += 4000;
            } else if (kindCount == 7) {
                points += 2000;
            } else if (kindCount == 6) {
                points += 1000;
            } else if (kindCount == 5) {
                points += 500;
            } else if (kindCount == 4) {
                points += 200;
            } else if (kindCount == 3) {
                points += 100;
            }
        }

        points += card.getPointsForTurn(rolls);
    }

    public void playTurn() {
        Card card = Card.drawCard(cards);
        ArrayList<Faces> turnFaces = dice.rollDice(card.getFaces());
        addPoints(turnFaces, card);

        System.out.println("Player's Card is: " + card);
        System.out.println("Player's Dices are: " + turnFaces);
        System.out.println("Player's Points are " + points);
    }

    public void reset(Boolean otherPlayerWon) {
        if (!otherPlayerWon && won()) {
            wins += 1;
        }
        points = 0;
    }

    public int getPoints() {
        return points;
    }
}
