package pk;
import java.util.ArrayList;
import java.util.Random;


public abstract class Dice {
    protected Faces roll() {
        int howManyFaces = Faces.values().length;
        Random bag = new Random();
        return Faces.values()[bag.nextInt(howManyFaces)];
    }

    public abstract ArrayList<Faces> rollDice(ArrayList<Faces> cardFaces);

    public static Dice getDice(String strategy) {
        if (strategy.equals("random")) {
            return new RandomDice();
        } else if (strategy.equals("combo")) {
            return new ComboDice();
        }
        return null;
    }
}


