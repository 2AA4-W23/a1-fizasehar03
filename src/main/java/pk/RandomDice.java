package pk;

import java.util.ArrayList;
import java.util.Random;

public class RandomDice extends Dice {
    public ArrayList<Faces> rollDice(ArrayList<Faces> cardFaces) {
        ArrayList<Faces> rolls = new ArrayList<>();

        int skulls = 0;
        for (int i = 0; i < 8; i++) {
            rolls.add(roll());
        }

        Random bool = new Random();
        boolean roll = bool.nextBoolean();
        if (roll) {
            do {
                for (int j = 0; j < 8; j++) {
                    int index = (int) (Math.random() * rolls.size());
                    if (rolls.get(index) != Faces.SKULL) {
                        rolls.set(index, roll());
                    }
                }
                for (Faces j : rolls) {
                    if (j == Faces.SKULL) {
                        skulls += 1;
                    }
                }
            } while (skulls <= 3);
        }
        return rolls;
    }
}
