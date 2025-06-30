package generalAmbiguous.games.ace;

import generalAmbiguous.games.ace.Card.CardType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static generalAmbiguous.ShuffleArray.shuffleArray;
import static helperUtil.StringUtils.toUpperCase;

public class DeckOfCard {

    private final static Object[][] cardByOrder = new Object[][]{{"A", 14}, {"K", 13}, {"Q", 12}, {"J", 11}, {"10", 10}, {"9", 9}, {"8", 8}, {"7", 7}, {"6", 6}, {"5", 5}, {"4", 4}, {"3", 3}, {"2", 2}};
    public final static Map<String, Integer> CARD_BY_ORDER = Stream.of(cardByOrder).collect(Collectors.toMap(p -> (String) p[0], p -> (Integer) p[1]));

    public static List<Card> getDeckOfCards() {
        List<Card> cards = new ArrayList<>();
        CardType[] cardTypes = CardType.values();
        for (Card.CardType cardType : cardTypes) {
            Collection<String> cardValues = CARD_BY_ORDER.keySet();
            for (String cardValue : cardValues) {
                cards.add(new Card(cardValue, cardType));
            }
        }
        return cards;
    }

    public static List<Card> getDeckOfCardsWithShuffle() {
        List<Card> cards = getDeckOfCards();
        int shuffleCount = (int) (Math.random() * 5);
        do {
            shuffleArray(cards);
        } while (shuffleCount-- < 0);
        return cards;
    }

    public static Card transformToCard(String card) {
        StringBuilder sb = new StringBuilder(card);
        return new Card(toUpperCase(sb.substring(1)), toUpperCase(sb.substring(0, 1)));
    }

}
