package pk;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Player {
    public Logger log = LogManager.getRootLogger();

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
            if (card.getType() == "monkey") {
                if (rolls.get(k) == Faces.PARROT) {
                    rolls.set(k, Faces.MONKEY);
                }
            }
        }
        // Check if the card is monkey, and replace all parrots with monkeys
        int saberCount = 0;
        int monkeyCount = 0;
        int parrotCount = 0;
        int diamondCount = 0;
        int goldCount = 0;

        for (int k = 0; k < 8; k++) {
            if (rolls.get(k) == Faces.DIAMOND) {
                diamondCount++;
            }
            if (rolls.get(k) == Faces.GOLD) {
                goldCount++;
            }
            if (rolls.get(k) == Faces.MONKEY) {
                monkeyCount++;
            }
            if (rolls.get(k) == Faces.PARROT) {
                parrotCount++;
            }
            if (rolls.get(k) == Faces.SABER) {
                saberCount++;
            }
        }
        //combo
        for (int p = 3; p < 8; p++) {
            if (saberCount == p) {
                int addPoints = (p < 5) ? (p - 2) * 100 : 500 * (int) Math.pow(2, p - 5);
                points += addPoints;
            }
            if (goldCount == p) {
                int addPoints = (p < 5) ? (p - 2) * 100 : 500 * (int) Math.pow(2, p - 5);
                points += addPoints;
            }
            if (diamondCount == p) {
                int addPoints = (p < 5) ? (p - 2) * 100 : 500 * (int) Math.pow(2, p - 5);
                points += addPoints;
            }
            if (parrotCount == p) {
                int addPoints = (p < 5) ? (p - 2) * 100 : 500 * (int) Math.pow(2, p - 5);
                points += addPoints;
            }
            if (monkeyCount == p) {
                int addPoints = (p < 5) ? (p - 2) * 100 : 500 * (int) Math.pow(2, p - 5);
                points += addPoints;
            }
        }
        points += card.getPointsForTurn(rolls);
    }
    public void playTurn() {
        Card card = Card.drawCard(cards);
        ArrayList<Faces> turnFaces = dice.rollDice(card.getFaces());
        addPoints(turnFaces, card);

        log.trace("Player's Card is: " + card);
        log.trace("Player's Dices are: " + turnFaces);
        log.trace("Player's Points are " + points);
    }
    public void reset(Boolean otherPlayerWon) {
        if (!otherPlayerWon && won()) {
            wins += 1;
        }
        points = 0;
    }
}
