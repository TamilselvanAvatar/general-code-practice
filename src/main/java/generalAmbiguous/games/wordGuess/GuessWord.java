package generalAmbiguous.games.wordGuess;

import java.util.Scanner;

import static helperUtil.StringUtils.YES;
import static helperUtil.StringUtils.equalIgnoreCase;

public class GuessWord {
    private final static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Let Start Guess the Word...");
        System.out.println("How Many Letter Your Word Have?");
        int noOfLetter = SCANNER.nextInt();
        SCANNER.nextLine();
        startGuess(noOfLetter);
    }

    private static void startGuess(int noOfLetter) {
        GuessLogic gl = new GuessLogic();
        gl.display();
        checkEachSet(true, gl, noOfLetter);
        checkEachSet(false, gl, noOfLetter);
        System.out.println("Your Word is " + gl.guessTheWord());
    }

    private static void checkEachSet(boolean isRow, GuessLogic gl, int noOfLetter) {
        for (int i = 1; i <= noOfLetter; i++) {
            while (true) {
                System.out.printf("Do you find your %d letter here in this set (YES/NO)%n%s%n", i, gl.getRowOrColumn(isRow));
                String yes = SCANNER.nextLine();
                if (equalIgnoreCase(YES, yes)) {
                    gl.setPositionByLetterPlace(true, isRow, i);
                    break;
                } else {
                    gl.setPositionByLetterPlace(false, isRow, i);
                }
            }
        }
    }

}
