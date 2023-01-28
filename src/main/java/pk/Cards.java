package pk;

import java.util.ArrayList;
import java.util.Random;

public class Cards {

    public int numSwords;
    public int points;
    public String type;

    public Cards(String type, int numSwords, int points) {
        this.numSwords = numSwords;
        this.points = points;
        this.type = type;
    }

    public static ArrayList<Cards> making_cards(ArrayList<Cards> cards) {


        for (int i = 0; i <= 6; i++) {
            if (i <= 2) {
                cards.add(new Cards("sea battle", 2, 300));
            } else if (i > 2 && i <= 4) {
                cards.add(new Cards("sea battle", 3, 500));
            } else if (i > 4 && i <= 6) {
                cards.add(new Cards("sea battle", 4, 1000));
            }
        }
        for (int i = 0; i <= 29; i++) {
            cards.add(new Cards("NOP", 0, 0));
        }
        return cards;
    }
    public static Cards draw_cards(ArrayList<Cards> cards) {
        Random card_draw = new Random();
        int index = card_draw.nextInt(cards.size());
        Cards card_drawn = cards.get(index);


        return card_drawn;
    }

    public String getType(){
        return type;
    }

    public int getPoints(){
        return points;
    }

    public int getNumSwords(){
        return numSwords;
    }


}



