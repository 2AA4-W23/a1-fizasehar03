import pk.*;

import java.sql.SQLOutput;
import java.util.Collections;
import java.util.Random;
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;

public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        Dice myDice = new Dice();
        Player player1 = new Player();
        Player player2 = new Player();

        int draw = 0;

            for (int games = 1; games < 43; games++) {


                while (player1.get_points() < 1000 && player2.get_points() < 1000) {


                    System.out.print("Player1's Dices are: ");
                    Player.player1 = myDice.rolling_dice();
                    player1.add_points(Player.player1);

                    System.out.println("\n" + "player 1's points are " + player1.get_points() + "\n");
                    System.out.print("Players2's dices are:");
                    Player.player2 = myDice.rolling_dice();
                    player2.add_points(Player.player2);
                    System.out.println("\n" + "player 2's points are " + player2.get_points() + "\n");

                }

                if (player1.get_points() >= 1000 && player2.get_points() >= 1000) {
                    draw++;//reroll try
                } else if (player1.get_points() >= 1000 && player1.get_points() > player2.get_points()) {
                    player1.add_win();
                } else {
                    player2.add_win2();
                }
                player1.set_points();
                player2.set_points();

                System.out.println(player1.get_points());
                System.out.println(player2.get_points());

                System.out.println("Player1s wins are: " + player1.get_win());
                System.out.println("Player2s wins are: " + player2.get_win2());
                System.out.println("Draw: " + draw);
                System.out.println("------------------------------------------");
                System.out.println("Game " + games + " ends");
                System.out.println("------------------------------------------");

            double Percentage_p1 = player1.get_win() * 100 / 42;
            double Percentage_p2 = player2.get_win2() * 100 / 42;
            double percentage_draw = (draw * 100) / 42;
            System.out.println("The percentage of wins of player 1 is : " + Percentage_p1);
            System.out.println("The percentage of wins of player 2 is : " + Percentage_p2);
            System.out.println("The percentage of draw is: " + percentage_draw);
        }
    }
}