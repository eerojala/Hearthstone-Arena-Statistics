package Xml;

import Xml.XmlParser;
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
            Element node = (Element) childlist.get(i);
            matches.add(createMatch(node));
        }
    }

    private Match createMatch(Element node) {
        DeckClass opponentClass = getDeckClassValue(node, "OpponentClass");
        String opponentName = getStringValue(node, "OpponentName");
        Outcome outcome = getOutcomeValue(node, "Outcome");
        boolean wentFirst = getBooleanValue(node, "WentFirst");
        String id = getID(node);
        int deckNumber = Integer.parseInt(id.split("\\.")[0]);
        int matchNumber = Integer.parseInt(id.split("\\.")[1]);      
        return new Match(opponentClass, opponentName, outcome,
                wentFirst, deckNumber, matchNumber);
    }

    public List<Match> getMatches() {
        return matches;
    }

}
