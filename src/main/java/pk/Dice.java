package pk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Dice {

    public Faces roll() {
        int howManyFaces = Faces.values().length;
        Random bag = new Random();
        return Faces.values()[bag.nextInt(howManyFaces)];
    }

    public static void seaBattle() {



    }


    public ArrayList<Faces> rolling_dice() {
        Cards new_card = null;
        ArrayList<Faces> rolls = new ArrayList<>();

        int skulls = 0;
        for (int i = 0; i < 8; i++) {
            rolls.add(roll());

        }
        System.out.print(rolls);
        Random bool = new Random();
        boolean roll = bool.nextBoolean();

        while (roll == true) {

            for (int j = 0; j < 8; j++) {
                int index = (int) (Math.random() * rolls.size());
                if (rolls.get(index) != Faces.SKULL) {
                    rolls.set(index, roll());
                }
            }
            System.out.println("\n" + rolls + "\n");
            for (Faces j : rolls) {
                if (j == Faces.SKULL) {
                    skulls += 1;
                }
            }
            if (skulls > 3) {
                break;
            }
        }
        return rolls;
    }


    public ArrayList<Faces> rolling_combos() {
        ArrayList<Faces> rolls = new ArrayList<>();
        int skulls = 0;
        Faces combo_num = null;
        int max_combos = 0;


        for (int i = 0; i < 8; i++) {
            rolls.add(roll());
        }

        System.out.print(rolls);
        for (Faces i : rolls) {
            int type = Collections.frequency(rolls, i);
            if (type > max_combos) {
                max_combos = type;
                combo_num = i;
            }
        }

        while (max_combos < 3 && skulls <= 3) {
            for (int j = 1; j < 8; j++) {
                if (rolls.get(j) != Faces.SKULL && combo_num != rolls.get(j)) {
                    rolls.set(j, roll());
                }
                max_combos = Collections.frequency(rolls, combo_num);

            }
            for (int i = 0; i < 8; i++) {
                if (rolls.get(i) == Faces.SKULL) {
                    skulls += 1;
                }
            }
            if (skulls > 3) {
                break;
            }

        }return rolls;

    }
}


