import pk.Dice;

public class PiratenKarpen {

    public static void main(String[] args) {
        System.out.println("Welcome to Piraten Karpen Simulator!");
        System.out.println("I'm rolling a dice");
        Dice myDice = new Dice();
        System.out.print("Player1's Dices are: ");

        int games = 42;

        for (int i = 0; i < 7; i++) {
            String player1[] = new String[7];
            player1[i] = String.valueOf(myDice.roll());
            System.out.print(player1[i] + " ");

        }
        System.out.println();
        System.out.print("Player2's Dices are: ");
        for (int i = 0; i < 7; i++) {
            String player2[] = new String[7];
            player2[i] = String.valueOf(myDice.roll());
            System.out.print(player2[i] + " ");
        }

        while (games<42){







        }

    }
}