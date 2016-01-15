package xml;

import domain.Card;
import domain.Deck;
import java.util.List;
import org.jdom.Attribute;
import org.jdom.Element;

/**
 * Class which writes data from the current deck into a Xml file.
 */
public class DeckWriter extends XmlWriter {

    /**
     * Creates a new DeckWriter Object.
     * 
     * @param filePath File path to the Xml file.
     */
    public DeckWriter(String filePath) {
        super(filePath, "Decks", "Deck");
    }

    @Override
    public void writeContent(Object obj) {
        try {
            Deck deck = (Deck) obj;
            Element element = new Element("Deck");
            element.addContent(new Element("DeckNumber").setText("" + deck.getDeckNumber()));
            element.setAttribute(new Attribute("id", "" + deck.getDeckNumber()));
            element.addContent(new Element("PlayerClass").setText(deck.getDeckClass().getName()));
            element.addContent(new Element("Gold").setText("" + deck.getGold()));
            element.addContent(new Element("Dust").setText("" + deck.getDust()));
            element.addContent(new Element("ExtraPacks").setText("" + deck.getExtraPacks()));
            addCards(element, deck);
            doc.getRootElement().addContent(element);
            addToFile();
        } catch (Exception e) {
        }
    }

    private void addCards(Element element, Deck deck) {
        Element cardsElement = new Element("Cards");
        List<Card> cards = deck.getRewardCards();
        for (int i = 0; i < cards.size(); i++) {
            Element cardElement = new Element("Card" + (i + 1));
            cardElement.setText(cards.get(i).getType());
            cardsElement.addContent(cardElement);
        }
        element.addContent(cardsElement);
    }

}
