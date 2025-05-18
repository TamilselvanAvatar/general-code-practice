package code360;

import java.util.List;

/**
 * Problem statement
 * <p>You’re given a slot machine with four slots where each slot will contain the color Red(R), Yellow(Y), Green(G), Blue(B), respectively. You don’t know the colors of this slot beforehand. You have to guess the colors. When you guess the correct color for the correct slot, you get a perfect hit, and you get 2 points, but if you guess a color that exists in the machine but is in the wrong slot, you get a pseudo hit, and you get 1 point.
 *
 * <p>You’re given the original string representing the slots’ colors and the guess string, and your task is to calculate and return the total number of points you have scored.
 *
 * <p>Note:
 *
 * <p>A slot that has been counted as a perfect hit can never count as a pseudo-hit.
 * <p>Example:
 *
 * <p>Original String = “RGYB” and Guess String = “YGRR”.
 * <p>2+1+1 = 4</p>
 */

public class GuessSlot {
    public static void main(String[] args) {
        List<String> list = List.of(
                "RGYB,YGRR",
                "YRBR,BRYY",
                "GRBB,RRGB",
                "RGYY,GGRB",
                "BGGG,GBGG",
                "BGRY,BGRG"
        );
        /*
            Expected result:
            4
            4
            5
            3
            6
            6
        */
        for (int i = 0; i < list.size(); i++) {
            String[] str = list.get(i).split(",");
            int ans = slotScore(str[0], str[1]);
            System.out.println("Points for " + i + " = " + ans);
        }
    }

    public static int slotScore(String o, String g) {
        int result = 0;
        StringBuilder original = new StringBuilder(o);
        StringBuilder guess = new StringBuilder(g);

        for (int i = 0; i < original.length(); i++) {
            if (o.charAt(i) == g.charAt(i)) {
                result += 2;
                guess.replace(i, i + 1, "+");
            } else {
                for (int j = 0; j < guess.length(); j++) {
                    if (original.charAt(i) == guess.charAt(j)) {
                        if(original.charAt(j) == guess.charAt(j)){
                            result += 2;
                        } else {
                            result += 1;
                        }
                        guess.replace(j, j + 1, "+");
                        break;
                    }
                }
            }
        }

        System.out.println(original);
        System.out.println(guess);

        return result;
    }

}
