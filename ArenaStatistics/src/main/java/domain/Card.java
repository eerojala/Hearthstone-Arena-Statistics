package domain;

import java.util.ArrayList;
import java.util.List;

public enum Card {

    COMMON("Common", false),
    RARE("Rare", false),
    EPIC("Epic", false),
    LEGENDARY("Legendary", false),
    COMMON_GOLD("Golden Common", true),
    RARE_GOLD("Golden Rare", true),
    EPIC_GOLD("Golden Epic", true),
    LEGENDARY_GOLD("Golden Legendary", true);

    private final String type;
    private final boolean golden;

    private Card(String type, boolean golden) {
        this.type = type;
        this.golden = golden;
    }

    public String getType() {
        return type;
    }

    public boolean isGolden() {
        return golden;
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
