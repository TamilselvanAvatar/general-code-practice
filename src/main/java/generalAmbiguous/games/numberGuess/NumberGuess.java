package generalAmbiguous.games.numberGuess;

import java.util.Scanner;

public class NumberGuess {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        startGuessNumber();
    }

    private static void startGuessNumber() {
        System.out.println("Think Of A Number (X)");
        System.out.println("Multiply Your Number With 2 (R = X * 2)");
        System.out.println("Add The Result With 5 (R = R + 5)");
        System.out.println("Multiply The Result With 3 (R = R * 3)");
        System.out.println("Subtract The Result By 15 (R = R - 15)");
        System.out.println("Enter The Final Result:");
        int finalResult = SCANNER.nextInt();
        // STEPS: [(((X*2) + 5) * 3) - 15]
        int yourNumber = (((finalResult + 15) / 3) - 5) / 2;
        System.out.println("Your Number IS " + yourNumber);
    }
}
