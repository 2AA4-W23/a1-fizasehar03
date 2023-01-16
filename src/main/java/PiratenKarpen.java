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
        System.out.println("I'm rolling a dice");
        Dice myDice = new Dice();
        Player player1 = new Player();
        Player player2 = new Player();
        double player1_wins = 0;
        double player2_wins = 0;
        int draw = 0;



        for (int games = 1; games < 43; games++) {
            double points_p1 = 0;
            double points_p2 = 0;

            while (points_p1 < 1000 && points_p2 < 1000) {
                myDice.points = 0;
                System.out.println();
                System.out.print("Player1's Dices are: ");
                Player.player1 = myDice.rolling_dice();
                points_p1 += myDice.player_points(Player.player1);
                myDice.points = 0;
                System.out.println();
                System.out.println("player 1's points are " + points_p1);
                System.out.println();
                System.out.print("Players2's dices are:");
                Player.player2 = myDice.rolling_dice();
                points_p2 += myDice.player_points(Player.player2);
                System.out.println();
                System.out.println("player 2's points are " + points_p2);
            }

            if (points_p1 > 1000 && points_p2 > 1000) {
                draw++;
            } else if (points_p1 > 1000 && points_p1 > points_p2) {
                player1_wins++;
            } else {
                player2_wins++;

            }
            System.out.println();
            System.out.println("Player1s wins are: " + player1_wins);
            System.out.println("Player2s wins are: " + player2_wins);
            System.out.println("Draw: " + draw);

            System.out.println("------------------------------------------");
            System.out.println("Game " + games + " ends");
            System.out.println("------------------------------------------");


        }
        double Percentange_p1 = (player1_wins / 42) * 100;
        double Percentange_p2 = (player2_wins / 42) * 100;
        System.out.println(Percentange_p1);
        System.out.println(Percentange_p2);
    }
        }
