package pk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Player {

    public static ArrayList<Faces> player1;
    public static ArrayList<Faces> player2;

    private Cards currentCard;


    public double points = 0;
    public double wins = 0;
    public double wins2 = 0;

    public void add_win() {
        wins++;
        points = 0;
    }

    public double get_win() {

        return wins;
    }

    public void add_win2() {
        wins2++;
        points = 0;
    }

    public double get_win2() {

        return wins2;
    }


    private Cards card;

    public void drawCard(ArrayList<Cards> cards) {
        this.card = Cards.draw_cards(cards);
    }



    public void add_points(ArrayList<Faces> rolls) {

        int skulls = 0;
        for (int k = 0; k < 8; k++) {
            if (rolls.get(k) == Faces.DIAMOND || rolls.get(k) == Faces.GOLD) {
                points += 100;
            }
            int kind_count = 1;

            for (int p = k + 1; p < 8; p++) {
                if (rolls.get(k) == rolls.get(p)) {
                    kind_count++;
                }

            }
            if (kind_count == 8) {
                points += 4000;
            } else if (kind_count == 7) {
                points += 2000;
            } else if (kind_count == 6) {
                points += 1000;
            } else if (kind_count == 5) {
                points += 500;
            } else if (kind_count == 4) {
                points += 200;

            } else if (kind_count == 3) {
                points += 100;
            }
        }

        for (Faces j : rolls) {
            if (j == Faces.SKULL) {
                skulls += 1;
            }
        }

        if (skulls >= 3) {
            points = 0;
        }
    }
        public void set_points () {
            points = 0;
        }
        public double get_points () {
            return points;
        }
}










