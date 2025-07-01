package generalAmbiguous.games.ace;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

import static generalAmbiguous.games.ace.DeckOfCard.CARD_BY_ORDER;
import static helperUtil.StringUtils.equalIgnoreCase;

@Getter
@Setter
public class Card implements Comparable<Card> {
    private Integer order;
    private String value;
    private CardType type;

    public Card(String value, CardType type) {
        this.value = value;
        this.type = type;
        this.order = CARD_BY_ORDER.get(value);
    }

    public Card(String value, String type) {
        this(value, CardType.valueOf(type));
    }

    public boolean isSameType(Card choseCard) {
        return this.type.equals(choseCard.getType());
    }

    public boolean isStartingCard() {
        return CardType.S.equals(this.type) && equalIgnoreCase("A", this.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.value);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Card)) return false;
        if (this == o) return true;
        return this.toString().equals(o.toString());
    }

    @Override
    public String toString() {
        return String.format("%s%s", this.type, this.value);
    }

    @Override
    public int compareTo(Card card) {
        return card.getOrder().compareTo(this.order); // DESC Order
    }

    @Getter
    public enum CardType {
        C("CLOVER", "♣"),
        D("DIAMOND", "♦"),
        H("HEART", "♥"),
        S("SPADE", "♠");

        private final String type;
        private final String symbol;

        CardType(String type, String symbol) {
            this.type = type;
            this.symbol = symbol;
        }

        @Override
        public String toString() {
            return symbol;
        }

    }

}