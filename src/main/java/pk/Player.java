package pk;

import java.util.ArrayList;

public class Player {

    public static ArrayList<Faces> player1;
    public static ArrayList<Faces> player2;
    public double points = 0;
    public double wins = 0;
    public double wins2 = 0;

    public void add_win() {
        wins++;
        points=0;

    }
    public double get_win() {

        return wins;
    }
    public void add_win2() {
        wins2++;
        points=0;

    }
    public double get_win2() {

        return wins2;
    }

    int kind_count;
    public void add_points(ArrayList<Faces>rolls) {



        for (int k = 0; k < 8; k++) {
            if (rolls.get(k) == Faces.DIAMOND || rolls.get(k) == Faces.GOLD) {
                points += 100;
            }//figure this out
            if(skulls==3){
                points=0;
            }
            for(int p = k+1; p<8;p++) {
                if (rolls.get(k) == rolls.get(p)) {
                    kind_count++;
                }
            }
            }if(kind_count==3){
                points+=300;
            }if(kind_count==3){
                points+=400;}
            if(kind_count==3){
                points+=500;}
            if(kind_count==3){
                points+=600;}
            if(kind_count==3){
                points+=700;}
            if(kind_count==3){
                points+=800;
            }
        }

    public void set_points(){
        points=0;
    }
    public double get_points(){
        return points;
    }
}
