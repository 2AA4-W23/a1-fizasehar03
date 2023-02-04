package pk;

import java.util.ArrayList;
import java.util.Random;

public class Card {
    private int numSwords;
    private int points;
    private String type;
    private ArrayList<Faces> faces;

    public Card(String type, int numSwords, int points, ArrayList<Faces> faces) {
        this.numSwords = numSwords;
        this.points = points;
        this.type = type;
        this.faces = faces;
    }

    public static ArrayList<Card> constructCards() {
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            ArrayList<Faces> seaBattleFaces = new ArrayList<>();
            seaBattleFaces.add(Faces.SABER);
            if (i <= 2) {
                cards.add(new Card("sea battle", 2, 300, seaBattleFaces));
            } else if (i > 2 && i <= 4) {
                cards.add(new Card("sea battle", 3, 500, seaBattleFaces));
            } else if (i > 4 && i <= 6) {
                cards.add(new Card("sea battle", 4, 1000, seaBattleFaces));
            }
        }
        for (int i = 0; i <= 4; i++) {
            ArrayList<Faces> monkeyFaces = new ArrayList<>();
            monkeyFaces.add(Faces.MONKEY);
            monkeyFaces.add(Faces.PARROT);
            cards.add(new Card("monkey", 0, 0, monkeyFaces));
        }
        for (int i = 0; i <= 25; i++) {
            cards.add(new Card("NOP", 0, 0, null));
        }
        return cards;
    }

    public static Card drawCard(ArrayList<Card> cards) {
        Random card_draw = new Random();
        int index = card_draw.nextInt(cards.size());
        return cards.get(index);


    }

    public ArrayList<Faces> getFaces() {
        return faces;
    }

    public int getPointsForTurn(ArrayList<Faces> turn) {
        if (faces == null || faces.size() > 1) {
            // We can't deal with points for complex cards with multiple faces,
            // the case we do deal with (monkey) adds no points anyway.
            return 0;
        }
        Faces cardFace = faces.get(0);
        int faceCount = 0;
        for (Faces face : turn) {
            if (face == cardFace) {
                faceCount += 1;
                if (faceCount >= numSwords) {
                    return points;
                }
            }
        }

        return -points;
    }

    public String toString() {
        return type + " card, " + numSwords + " swords, " + points + " points";
    }
    public String getType(){
        return type;
    }
}


