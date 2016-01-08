package xml;

import xml.XmlParser;
import domain.*;
import java.util.ArrayList;
import java.util.List;
import org.jdom.Document;
import org.jdom.Element;

public class MatchParser extends XmlParser {

    private final List<Match> matches;

    public MatchParser(String filepath) {
        super(filepath, "Match", "Matches");
        matches = new ArrayList();
    }

    public MatchParser(Document doc) {
        super(doc, "Match");
        matches = new ArrayList();
    }

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
    
    public List<Match> getMatches() {
        return matches;
    }
}
