package xml;

import domain.*;
import java.util.ArrayList;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;

public class DeckParser extends XmlParser {

    private Deck deck;

    public DeckParser(String fileName) {
        super(fileName, "Deck", "Decks");
    }
    
    public DeckParser(Document doc) {
        super(doc, "Deck");
    }

    @Override
    public void addValues() {
        for (int i = 0; i < childlist.size(); i++) {
            Element node = (Element) childlist.get(i);
            deck = createDeck(node);
        }
    }

    private Deck createDeck(Element element) {
        int deckNumber = Integer.parseInt(getID(element));
        DeckClass playerClass = getDeckClassValue(element, "PlayerClass");
        Deck deck = new Deck(playerClass, deckNumber);
        deck.setGold(getIntValue(element, "Gold"));
        deck.setDust(getIntValue(element, "Dust"));
        deck.setExtraPacks(getIntValue(element, "ExtraPacks"));
        deck.setCards(getCards(element));
        return deck;
    }

    private List<Card> getCards(Element element) {
        List<Card> cards = new ArrayList();
        int i = 1;
        while (true) {
            try {
                cards.add(Card.parseCard(element.getChild("Cards").getChild("Card" + i).getText()));
                i++;
            } catch (Exception e) {
                break;
            }
        }
        return cards;
    }

    public Deck getDeck() {
        return deck;
    }

}
