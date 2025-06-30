package generalAmbiguous.games.ace;

import generalAmbiguous.games.ace.Card.CardType;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

import static generalAmbiguous.games.ace.DeckOfCard.transformToCard;
import static helperUtil.CollectionUtils.isEmpty;
import static helperUtil.CollectionUtils.isNotEmpty;
import static helperUtil.GeneralUtils.computeIfNull;

@Getter
@Setter
public class Player {

    private static boolean isGameStarted;

    private final String id;

    private String name;
    private Card currentCard;
    private Boolean haveSameType;
    private Boolean haveAceSpadeCard;
    private boolean notToRemoveCurrentCard;
    private Map<CardType, Set<Card>> cardByType = new HashMap<>();

    public Player(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public Boolean getHaveAceSpadeCard() {
        return computeIfNull(this.haveAceSpadeCard, () -> Boolean.FALSE);
    }

    public void setCurrentCard(String card) {
        currentCard = transformToCard(card);
        Set<Card> cards = cardByType.get(currentCard.getType());
        if (isEmpty(cards) || !cards.contains(currentCard)) {
            currentCard = null;
            throw new RuntimeException(name + " doesn't have the card " + card);
        }
    }

    public void addCard(Card card) {
        if (haveAceSpadeCard == null && card.isStartingCard()) {
            haveAceSpadeCard = true;
        }
        cardByType.computeIfAbsent(card.getType(), (k) -> new TreeSet<>(Comparator.comparing(Card::getOrder))).add(card);
    }

    public void addCards(List<Card> cards) {
        if (isEmpty(cards)) {
            return;
        }
        cards.forEach(this::addCard);
    }


    public boolean haveMaxNumberCard(Player player) {
        return this.currentCard.getOrder() >= player.getCurrentCard().getOrder();
    }

    public void removeCard(Card card) {
        CardType type = card.getType();
        if (cardByType.containsKey(type)) {
            Set<Card> cards = cardByType.get(type);
            if (isNotEmpty(cards)) {
                cards.remove(card);
            }
            if (isEmpty(cards)) {
                cardByType.remove(type);
            }
        }
    }

    public void removeCurrentCard() {
        if (notToRemoveCurrentCard) {
            return;
        }
        removeCard(currentCard);
        currentCard = null;
    }

    public boolean isPlayerWin() {
        return isGameStarted && cardByType.isEmpty();
    }

    @Override
    public String toString() {
        return String.format("Player [ name: %s, Have Spade Ace: %s, cards: %s]", name, haveAceSpadeCard, cardByType);
    }

}
