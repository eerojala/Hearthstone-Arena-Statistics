package domain;

import java.util.ArrayList;
import java.util.List;

public enum Card {

    COMMON("Common"),
    RARE("Rare"),
    EPIC("Epic"),
    LEGENDARY("Legendary"),
    COMMON_GOLD("Golden Common"),
    RARE_GOLD("Golden Rare"),
    EPIC_GOLD("Golden Epic"),
    LEGENDARY_GOLD("Golden Legendary");

    private final String type;

    private Card(String xmlAbb) {
        this.type = xmlAbb;
    }

    public String getType() {
        return type;
    }

    public static Card parseCard(String text) {
        List<Card> list = initCardList();
        for (Card card : list) {
            if (text.equals(card.getType())) {
                return card;
            }
        }
        return null;
    }

    public static List<Card> initCardList() {
        List<Card> cardList = new ArrayList();
        cardList.add(Card.COMMON);
        cardList.add(Card.COMMON_GOLD);
        cardList.add(Card.RARE);
        cardList.add(Card.RARE_GOLD);
        cardList.add(Card.EPIC);
        cardList.add(Card.EPIC_GOLD);
        cardList.add(Card.LEGENDARY);
        cardList.add(Card.LEGENDARY_GOLD);
        return cardList;
    }
}
