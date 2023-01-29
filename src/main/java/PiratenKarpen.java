import pk.Card;
import pk.Dice;
import pk.Player;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;


public class PiratenKarpen {
    private static final Logger log = LogManager.getLogger(PiratenKarpen.class);

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");

        Dice player1Dice = Dice.getDice(args[0]);
        Dice player2Dice = Dice.getDice(args[1]);

        ArrayList<Card> cards = Card.constructCards();

        Player player1 = new Player(player1Dice, cards);
        Player player2 = new Player(player2Dice, cards);

        int draw = 0;
        for (int games = 1; games < 43; games++) {
            while (!player1.won() && !player2.won()) {
                System.out.println("Player 1:");
                player1.playTurn();
                System.out.println("");

                System.out.println("Player 2:");
                player2.playTurn();
                System.out.println("");
            }
            Boolean player1Won = player1.won();
            Boolean player2Won = player2.won();
            if (player1Won && player2Won) {
                draw++;
            }
            player1.reset(player2Won);
            player2.reset(player1Won);

            System.out.println("Player 1's wins are: " + player1.getWins());
            System.out.println("Player 2's wins are: " + player2.getWins());
            System.out.println("Draw: " + draw);
            System.out.println("------------------------------------------");
            System.out.println("Game " + games + " ends");
            System.out.println("------------------------------------------");
        }

        double percentageP1 = ((double) player1.getWins()) * 100 / 42;
        double percentageP2 = ((double) player2.getWins()) * 100 / 42;
        double percentageDraw = (((double) draw) * 100) / 42;
        System.out.printf("The percentage of wins of player 1 is : %.3f%%\n", percentageP1);
        System.out.printf("The percentage of wins of player 2 is : %.3f%%\n", percentageP2);
        System.out.printf("The percentage of draws is: %.3f%%\n", percentageDraw);
    }
}