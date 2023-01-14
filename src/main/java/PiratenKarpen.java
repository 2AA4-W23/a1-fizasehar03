import pk.*;

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
        int player1_wins = 0;
        int player2_wins = 0;



        for (int games = 1; games<43;games++){

            int points_p1=0;
            int points_p2=0;

            while (points_p1<1000 && points_p2<1000 ){

                System.out.print("Player1's Dices are: ");
                Player.player1=  myDice.rolling_dice();
                System.out.println();
                System.out.print("Players2's dices are:" );
                Player.player2=myDice.rolling_dice();
                points_p1+=myDice.player_points(Player.player1);
                points_p2+=myDice.player_points(Player.player2);

            }
            if (points_p1>1000 && points_p2>1000) {
                player1_wins++;
                player2_wins++;
            }else if(points_p1>1000 && points_p1>points_p2) {

                player1_wins++;
            }else{
                player2_wins++;

            }

            System.out.println(player1_wins);
            System.out.println(player2_wins);

        }


    }


        }
