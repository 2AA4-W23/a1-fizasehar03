import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;
import pk.Card;
import pk.Dice;
import pk.Player;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.module.Configuration;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;


public class PiratenKarpen {


    public static final Logger log = LogManager.getRootLogger();
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        Dice player1Dice = Dice.getDice(args[0]);
        Dice player2Dice = Dice.getDice(args[1]);

        if(args[2].equals("trace")){
            Configurator.setAllLevels(log.getName(), Level.TRACE);
        }
        log.trace("Welcome to Piraten Karpen Simulator!");

        ArrayList<Card> cards = Card.constructCards();

        Player player1 = new Player(player1Dice, cards);
        Player player2 = new Player(player2Dice, cards);

        int draw = 0;
        for (int games = 1; games < 43; games++) {
            while (!player1.won() && !player2.won()) {
                log.trace("Player 1:");
                player1.playTurn();
                log.trace("");

                log.trace("Player 2:");
                player2.playTurn();
                log.trace("");
            }
            Boolean player1Won = player1.won();
            Boolean player2Won = player2.won();
            if (player1Won && player2Won) {
                draw++;
            }
            player1.reset(player2Won);
            player2.reset(player1Won);

            log.trace("Player 1's wins are: " + player1.getWins());
            log.trace("Player 2's wins are: " + player2.getWins());
            log.trace("Draw: " + draw);
            log.trace("------------------------------------------");
            log.trace("Game " + games + " ends");
            log.trace("------------------------------------------");
        }

        double percentageP1 = ((double) player1.getWins()) * 100 / 42;
        double percentageP2 = ((double) player2.getWins()) * 100 / 42;
        double percentageDraw = (((double) draw) * 100) / 42;
        log.info("The percentage of wins of player 1 is : "+ df.format(percentageP1));
        log.info("The percentage of wins of player 2 is : " + df.format(percentageP2));
        log.info("The percentage of draws is: "+ df.format(percentageDraw));
    }
}