package xml;

import domain.*;
import java.util.ArrayList;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;

/**
 * Class which parses Data about the current deck's matches from a Xml file.
 */
public class MatchParser extends XmlParser {

    private final List<Match> matches;

    /**
     * Creates a new MatchParser Object.
     * 
     * @param filePath File path to the Xml file.
     */
    public MatchParser(String filePath) {
        super(filePath, "Match", "Matches");
        matches = new ArrayList();
    }

    /**
     * Creates a new MatchParser Object.
     * 
     * @param doc Document representation of the Xml document.
     */
    public MatchParser(Document doc) {
        super(doc, "Match");
        matches = new ArrayList();
    }

    /**
     * Adds the parsed matches to a List.
     */
    @Override
    public void addValues() {
        for (int i = 0; i < childlist.size(); i++) {
            Element element = (Element) childlist.get(i);
            matches.add(createMatch(element));
        }
    }

    private Match createMatch(Element element) {
        DeckClass playerClass = getDeckClassValue(element, "PlayerClass");
        DeckClass opponentClass = getDeckClassValue(element, "OpponentClass");
        String opponentName = getStringValue(element, "OpponentName");
        Outcome outcome = getOutcomeValue(element, "Outcome");
        boolean wentFirst = getBooleanValue(element, "WentFirst");
        String id = getID(element);
        int deckNumber = Integer.parseInt(id.split("\\.")[0]);
        int matchNumber = Integer.parseInt(id.split("\\.")[1]);
        return new Match(playerClass, opponentClass, opponentName, outcome,
                wentFirst, deckNumber, matchNumber);
    }

    @Override
    public Object getParsedObject() {
        return matches;
    }
    

}
