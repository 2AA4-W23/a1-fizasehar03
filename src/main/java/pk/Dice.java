package pk;
import java.util.ArrayList;
import java.util.Random;

public class Dice {



    public Faces roll() {
        int howManyFaces = Faces.values().length;
        Random bag = new Random();
        return Faces.values()[bag.nextInt(howManyFaces)];
    }


    int games = 0;

    int points = 0;

        public ArrayList<Faces> rolling_dice() {

            ArrayList<Faces> rolls = new ArrayList<>();
            int skulls = 0;
            int dice_left = 0;
            int rounds = 0;
            for (int i = 0; i < 8; i++) {
                rolls.add(roll());
            }


            while (skulls < 3) {
                skulls = 0;
                for (int j = 0; j < 8; j++) {
                    // generating the index using Math.random()
                    int index = (int) (Math.random() * rolls.size());
                    if (rolls.get(index) != Faces.SKULL) {
                        rolls.set(index, roll());
                    }
                }
                System.out.println();

                for (int i = 0; i < 8; i++) {
                    System.out.print(rolls.get(i) + " ");
                }
                for (Faces j : rolls) {
                    if (j == Faces.SKULL) {
                        skulls++;
                        dice_left--;
                    }
                }
            }
            return rolls;
        }

            public int player_points(ArrayList < Faces > rolls) {
                for (int k = 0; k < 8; k++) {
                    if (rolls.get(k) == Faces.DIAMOND || rolls.get(k) == Faces.GOLD) {
                        points += 100;
                        return points;
                    }
                }
                return 0;
            }
    }
