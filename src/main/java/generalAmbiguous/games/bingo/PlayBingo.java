package generalAmbiguous.games.bingo;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

import static generalAmbiguous.ShuffleArray.shuffleArray;
import static helperUtil.StringUtils.*;

public class PlayBingo {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String COMPUTER = "COMPUTER";

    public static void main(String[] args) {
        System.out.println("Enter Number of Players:");
        int playerCount = SCANNER.nextInt();
        SCANNER.nextLine();
        startBingo(playerCount);
    }

    private static void startBingo(int playerCount) {
        Map<String, Bingo> bingoByPlayerId = new HashMap<>();
        List<String> playerIds = fromPlayerIds(playerCount);
        AtomicBoolean isBingo = new AtomicBoolean(true);
        preSetTheBoard(playerIds, bingoByPlayerId);
        setComputerPlayer(playerIds, bingoByPlayerId);
        shuffleArray(playerIds);
        while (isBingo.get()) {
            List<String> bingoReachedPlayers = new ArrayList<>();
            for (String player : playerIds) {
                System.out.printf("Player %s Turn & Enter Value to Cross:%n", player);
                int value;
                if (COMPUTER.equals(player)) {
                    value = bingoByPlayerId.get(player).getNextCrossValue();
                    System.out.println(value);
                } else {
                    value = SCANNER.nextInt();
                }
                bingoByPlayerId.forEach((k, v) -> {
                    v.crossBingo(value);
                    if (v.isBingo()) {
                        bingoReachedPlayers.add(k);
                    }
                });
                if (!bingoReachedPlayers.isEmpty()) {
                    String bingoPlayer = bingoReachedPlayers.contains(player) ? player : bingoReachedPlayers.get(0);
                    System.out.printf("Player %s has won the Bingo (🎉).%n", bingoPlayer);
                    isBingo.set(false);
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

    private static void preSetTheBoard(List<String> players, Map<String, Bingo> bingoByPlayerId) {
        for (String player : players) {
            System.out.printf("Do you (Player %s) want to provide Bingo Box? (YES/NO)%n", player);
            String choice = SCANNER.nextLine();
            if (equalIgnoreCase(choice, YES)) {
                setCustomBingo(player, bingoByPlayerId);
            } else {
                Bingo playerBingo = new Bingo();
                bingoByPlayerId.put(player, playerBingo);
                System.out.printf("Player %s: Below is Your Bingo Box%n", player);
                playerBingo.displayBingo();
            }
        }
    }

    private static void setCustomBingo(String currentPlayer, Map<String, Bingo> bingoByPlayerId) {
        try {
            System.out.println("Enter Bingo Box in Series (Separate By Comma) for the Player " + currentPlayer);
            String bingo = SCANNER.nextLine();
            Integer[] range = toStream(bingo.split(",")).map(Integer::parseInt).toArray(Integer[]::new);
            bingoByPlayerId.put(currentPlayer, new Bingo(range));
        } catch (Exception e) {
            System.out.println("There is error occurred (May be Space between Comma Or Provided Not Number)");
            System.out.printf("Player %s Try Again%n", currentPlayer);
            setCustomBingo(currentPlayer, bingoByPlayerId);
        }
    }

    private static void setComputerPlayer(List<String> players, Map<String, Bingo> bingoByPlayerId) {
        if (players.size() == 1) {
            players.add(COMPUTER);
            Bingo computer = new Bingo(true);
            bingoByPlayerId.put(COMPUTER, computer);
        }
    }

    private static List<String> fromPlayerIds(int playerCount) {
        List<String> playerIds = new ArrayList<>();
        for (int i = 1; i <= playerCount; i++) {
            playerIds.add(EMPTY + i);
        }
        return playerIds;
    }

}