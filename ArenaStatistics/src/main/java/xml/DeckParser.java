package xml;

import domain.*;
import java.util.ArrayList;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;

/**
 * Class which parses data of the current deck from a Xml file.
 */
public class DeckParser extends XmlParser {

    private Deck deck;

    /**
     * Creates a new DeckParser Object.
     * 
     * @param filePath File path to the Xml file.
     */
    public DeckParser(String filePath) {
        super(filePath, "Deck", "Decks");
    }
    
    /**
     * Creates a new DeckParser Object.
     * 
     * @param doc Document representation of the Xml Document.
     */
    public DeckParser(Document doc) {
        super(doc, "Deck");
    }

    /**
     * Parses the data of the Xml file to a Deck Object.
     */
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
        Deck newDeck = new Deck(playerClass, deckNumber);
        newDeck.setGold(getIntValue(element, "Gold"));
        newDeck.setDust(getIntValue(element, "Dust"));
        newDeck.setExtraPacks(getIntValue(element, "ExtraPacks"));
        newDeck.setRewardCards(getCards(element));
        return newDeck;
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

    @Override
    public Object getParsedObject() {
        return deck;
    }

    
    
}
