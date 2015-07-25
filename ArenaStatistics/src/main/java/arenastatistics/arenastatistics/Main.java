package arenastatistics.arenastatistics;

import Xml.DeckWriter;
import Xml.DocumentBuilder;
import Xml.MatchParser;
import Xml.MatchWriter;
import Xml.XmlParser;
import Xml.XmlWriter;
import domain.Card;
import domain.Deck;
import domain.DeckClass;
import domain.Match;
import domain.Outcome;
import java.util.ArrayList;
import java.util.List;
import org.jdom.Document;

public class Main {

    public static void main(String[] args) {
        Deck deck1 = new Deck(DeckClass.DRUID, 1);
        XmlWriter writer = new DeckWriter("src/main/resources/DeckWriteTest.xml");
        Document doc = DocumentBuilder.buildDocument("src/main/resources/DeckWriteTest.xml");
        List<Card> cards = new ArrayList();
        cards.add(Card.RARE);
        cards.add(Card.LEGENDARY);
        cards.add(Card.RARE);
        deck1.setCards(cards);
        writer.addContent(doc, deck1);
    }

}
