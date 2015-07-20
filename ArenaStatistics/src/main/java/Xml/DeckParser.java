package Xml;

import Xml.XmlParser;
import domain.*;
import java.util.ArrayList;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;

public class DeckParser extends XmlParser {

    private List<Deck> decks;

    public DeckParser(String fileName) {
        super(fileName, "Deck");
        decks = new ArrayList();
        addValuesToList();
    }
    
    public DeckParser(Document doc) {
        super(doc, "Deck");
        decks = new ArrayList();
        addValuesToList();
    }

    @Override
    public void addValuesToList() {
        for (int i = 0; i < childList.size(); i++) {
            Element node = (Element) childList.get(i);
            decks.add(createDeck(node));
        }
    }

    private Deck createDeck(Element node) {
        int deckNumber = Integer.parseInt(getId(node));
        DeckClass playerClass = getDeckClassValue(node, "PlayerClass");
        Deck deck = new Deck(playerClass, deckNumber);
        deck.setGold(getIntegerValue(node, "Gold"));
        deck.setDust(getIntegerValue(node, "Dust"));
        deck.setExtraPacks(getIntegerValue(node, "ExtraPacks"));
        deck.setCards(getCards(node));
        return deck;
    }

    private List<Card> getCards(Element node) {
        List<Card> cards = new ArrayList();
        int i = 1;
        while (true) {
            try {
                cards.add(Card.parseCard(node.getChild("Cards").getChild("Card" + i).getText()));
                i++;
            } catch (Exception e) {
                break;
            }
        }
        return cards;
    }

    public List<Deck> getDecks() {
        return decks;
    }

}
