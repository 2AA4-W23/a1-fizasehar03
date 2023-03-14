package pk;

import java.util.ArrayList;
import java.util.Collections;

public class ComboDice extends Dice {
    public ArrayList<Faces> rollDice(ArrayList<Faces> cardFaces) {
        ArrayList<Faces> rolls = new ArrayList<>();
        int skulls = 0;
        Faces combo_num = null;
        int max_combos = 0;

        for (int i = 0; i < 8; i++) {
            rolls.add(roll());
        }
        for (Faces i : rolls) {
            int type = Collections.frequency(rolls, i);
            if (type > max_combos) {
                max_combos = type;
                combo_num = i;
            }
        }
        while (max_combos < 4) {
            for (int j = 1; j < 8; j++) {
                if (rolls.get(j) != Faces.SKULL && combo_num != rolls.get(j)) {
                    if (cardFaces == null || !cardFaces.contains(cardFaces)) {
                        rolls.set(j, roll());
                    }
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
        }
        return rolls;
    }
}
