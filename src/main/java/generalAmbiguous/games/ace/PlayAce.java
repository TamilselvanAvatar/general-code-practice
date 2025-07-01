package generalAmbiguous.games.ace;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static generalAmbiguous.games.ace.DeckOfCard.getDeckOfCardsWithShuffle;
import static helperUtil.CollectionUtils.isEmpty;
import static helperUtil.Printer.printer;
import static helperUtil.StringUtils.EMPTY;
import static helperUtil.StringUtils.isEquals;

public class PlayAce {

    private final static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        List<Card> deckOfCards = getDeckOfCardsWithShuffle();
        List<Player> players = new ArrayList<>();
        initializePlayers(players);
        splitCards(deckOfCards, players);
        // startOfMiddle(players); // to test logic
        Player.setGameStarted(true);
        startGame(players);
    }

    private static void startOfMiddle(List<Player> players) {
        Player player1 = new Player("Player 1");
        player1.setHaveAceSpadeCard(true);
        player1.addCards(Stream.of("S2", "S3", "H7", "H4", "H5", "H3").map(DeckOfCard::transformToCard).collect(Collectors.toList()));

        Player player2 = new Player("Player 2");
        player2.addCards(Stream.of("S4", "S5", "D7", "D6", "C9").map(DeckOfCard::transformToCard).collect(Collectors.toList()));

        Player player3 = new Player("Player 3");
        player3.addCards(Stream.of("C6", "C2", "C3", "D9", "D10").map(DeckOfCard::transformToCard).collect(Collectors.toList()));

        players.add(player1);
        players.add(player2);
        players.add(player3);
    }

    private static void startGame(List<Player> players) {
        List<Player> copyPlayers = new ArrayList<>(players);
        int startIndex = findIndexOfPlayer(players, Player::getHaveAceSpadeCard);
        boolean isGameOver = false;
        do {
            boolean isThereCut = false;
            String currentPlayerId = EMPTY;
            List<Player> roundPlayers = new ArrayList<>();
            Stack<Player> playerStack = new Stack<>();
            setPlayers(playerStack, startIndex, players);
            if (playerStack.stream().filter(Player::isPlayerNotWin).count() == 1) {
                break;
            }
            Card previousCard = null;
            while (!playerStack.isEmpty()) {
                Player player = playerStack.pop();
                if (player.isPlayerWin()) {
                    players.remove(player);
                    continue;
                }
                System.out.println(player.getName() + " Will Give The Card: ");
                String choseCard = SCANNER.nextLine();
                try {
                    player.setCurrentCard(choseCard);
                    if (player.provideWrongTypeEvenExist(previousCard)) {
                        System.out.printf("%s Lose Because Provided Wrong Card", player.getName());
                        isGameOver = true;
                        break;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("Try Again: ");
                    playerStack.add(player);
                    continue;
                }
                previousCard = player.getCurrentCard();
                if (isMisMatchCardType(roundPlayers, previousCard)) {
                    roundPlayers.add(player);
                    isThereCut = true;
                    currentPlayerId = player.getId();
                    break;
                }
                roundPlayers.add(player);
            }
            if (isGameOver) {
                break;
            }
            String id = getMaxCardPlayerIdAndAddOrRemoveCard(players, roundPlayers, isThereCut, currentPlayerId);
            startIndex = findIndexOfPlayer(players, p -> isEquals(id, p.getId()));
        } while (players.size() != 1);
        printer(copyPlayers, "\n", "Players");
        if (!isGameOver) {
            System.out.printf("%s Lose", players.get(0).getName());
        }
    }

    private static String getMaxCardPlayerIdAndAddOrRemoveCard(List<Player> players, List<Player> roundPlayers, boolean isThereCut, String currentPlayerId) {
        List<Card> cards = new ArrayList<>();
        Player playerWithMaxCard = null;
        Predicate<Player> isCurrentPlayerWithCut = (player) -> !(isThereCut && isEquals(player.getId(), currentPlayerId));
        for (Player player : roundPlayers) {
            if (playerWithMaxCard == null || !playerWithMaxCard.haveMaxNumberCard(player)) {
                if (isCurrentPlayerWithCut.test(player)) {
                    playerWithMaxCard = player;
                }
            }
            cards.add(player.getCurrentCard());
        }
        assert playerWithMaxCard != null;
        if (isThereCut) {
            playerWithMaxCard.setNotToRemoveCurrentCard(true);
            playerWithMaxCard.addCards(cards);
        }
        players.forEach(Player::removeCurrentCard);
        playerWithMaxCard.setNotToRemoveCurrentCard(false);
        return playerWithMaxCard.getId();
    }

    private static boolean isMisMatchCardType(List<Player> roundPlayers, Card choseCard) {
        if (isEmpty(roundPlayers)) {
            return false;
        }
        for (Player player : roundPlayers) {
            Card playerCard = player.getCurrentCard();
            if (!playerCard.isSameType(choseCard)) {
                return true;
            }
        }
        return false;
    }

    private static int findIndexOfPlayer(List<Player> players, Function<Player, Boolean> consumer) {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (consumer.apply(player)) {
                return i;
            }
        }
        return -1;
    }

    private static void setPlayers(Stack<Player> playerStack, int startIndex, List<Player> players) {
        for (int i = startIndex - 1; i >= 0; i--) {
            playerStack.push(players.get(i));
        }
        for (int i = players.size() - 1; i >= startIndex; i--) {
            playerStack.push(players.get(i));
        }
    }

    private static void splitCards(List<Card> deckOfCards, List<Player> players) {
        Iterator<Card> iterator = deckOfCards.iterator();
        do {
            for (Player player : players) {
                if (iterator.hasNext()) {
                    player.addCard(iterator.next());
                }
            }
        } while (iterator.hasNext());

        printer(players, "\n", "Players");
    }

    private static void initializePlayers(List<Player> players) {
        System.out.println("Enter Number of Player");
        int playerCount = SCANNER.nextInt();
        SCANNER.nextLine();
        for (int i = 1; i <= playerCount; i++) {
            System.out.printf("Enter Player %d Name:%n", i);
            String name = SCANNER.nextLine();
            players.add(new Player(name));
        }
    }

}
