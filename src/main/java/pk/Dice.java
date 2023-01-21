package pk;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Dice {

    public Faces roll() {
        int howManyFaces = Faces.values().length;
        Random bag = new Random();
        return Faces.values()[bag.nextInt(howManyFaces)];
    }


    public ArrayList<Faces> rolling_dice() {

        Scanner s = new Scanner(System.in);
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
            System.out.println(rolls + "\n");
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
}


