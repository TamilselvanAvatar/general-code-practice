package generalAmbiguous.games.bingo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

import static helperUtil.StringUtils.equalIgnoreCase;
import static helperUtil.StringUtils.toStream;

public class PlayBingo {
    private static final Scanner sc = new Scanner(System.in);
    private static final String YES = "YES";

    public static void main(String[] args) {
        System.out.println("Enter Number of Players:");
        int playerCount = sc.nextInt();
        sc.nextLine();
        startBingo(playerCount);
    }

    private static void startBingo(int playerCount) {
        Map<Integer, Bingo> bingoByPlayerId = new HashMap<>();
        AtomicBoolean isBingo = new AtomicBoolean(true);
        preSetTheBoard(playerCount, bingoByPlayerId);
        while (isBingo.get()) {
            for (int player = 1; player <= playerCount; player++) {
                System.out.printf("Player %d Turn & Enter Value to Cross:%n", player);
                int value = sc.nextInt();
                bingoByPlayerId.forEach((k, v) -> {
                    v.crossBingo(value);
                    if (v.isBingo()) {
                        System.out.printf("Player %d has won the Bingo (🎉).%n", k);
                        isBingo.set(false);
                    }
                });
                if (!isBingo.get()) {
                    break;
                }
            }
        }
        Bingo.setLogger(true);
        bingoByPlayerId.forEach((k, v) -> {
            System.out.println("Bingo Box of Player " + k);
            v.displayBingo();
        });
    }

    private static void preSetTheBoard(int playerCount, Map<Integer, Bingo> bingoByPlayerId) {
        for (int player = 1; player <= playerCount; player++) {
            System.out.printf("Do you (Player %d) want to provide Bingo Box? (YES/NO)%n", player);
            String choice = sc.nextLine();
            if (equalIgnoreCase(choice, YES)) {
                setCustomBingo(player, bingoByPlayerId);
            } else {
                Bingo playerBingo = new Bingo();
                bingoByPlayerId.put(player, playerBingo);
                System.out.printf("Player %d: Below is Your Bingo Box%n", player);
                playerBingo.displayBingo();
            }
        }
    }

    private static void setCustomBingo(int currentPlayer, Map<Integer, Bingo> bingoByPlayerId) {
        try {
            System.out.println("Enter Bingo Box in Series (Separate By Comma) for the Player " + currentPlayer);
            String bingo = sc.nextLine();
            Integer[] range = toStream(bingo.split(",")).map(Integer::parseInt).toArray(Integer[]::new);
            bingoByPlayerId.put(currentPlayer, new Bingo(range));
        } catch (Exception e) {
            System.out.println("There is error occurred (May be Space between Comma Or Provided Not Number)");
            System.out.printf("Player %d Try Again%n", currentPlayer);
            setCustomBingo(currentPlayer, bingoByPlayerId);
        }
    }

}
