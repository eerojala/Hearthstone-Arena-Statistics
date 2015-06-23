package logic;

import domain.DeckClass;
import domain.Match;
import domain.Outcome;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class XMLParser {
    
    private final List<DeckClass> classList;
    private final List<Match> matches;

    public XMLParser() {
        matches = new ArrayList();
        classList = new ArrayList();
        classList.add(DeckClass.DRUID);
        classList.add(DeckClass.HUNTER);
        classList.add(DeckClass.MAGE);
        classList.add(DeckClass.PALADIN);
        classList.add(DeckClass.PRIEST);
        classList.add(DeckClass.ROGUE);
        classList.add(DeckClass.SHAMAN);
        classList.add(DeckClass.WARLOCK);
        classList.add(DeckClass.WARRIOR);
        parseXmlFile();
        
    }

    private void parseXmlFile() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            parseDocument(db.parse("Matches.xml"));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    private void parseDocument(Document dom) {
        Element docEle = dom.getDocumentElement();
        NodeList nl = docEle.getElementsByTagName("Employee");
        if (nl != null && nl.getLength() > 0) {
            for (int i = 0; i < nl.getLength(); i++) {
                Element el = (Element) nl.item(i);
                Match m = getMatch(el);
                matches.add(m);
            }
        }
    }

    private Match getMatch(Element matchEl) {
        DeckClass playerClass = getDeckClassValue(matchEl, "PlayerClass");
        DeckClass opponentClass = getDeckClassValue(matchEl, "OpponentClass");
        String opponentName = getTextValue(matchEl, "OpponentName");
        Outcome outcome = getOutcomeValue(matchEl, "Outcome");
        int deckNumber = getIntValue(matchEl, "DeckNumber");
        int matchNumber = getIntValue(matchEl, "MatchNumber");
        return new Match(playerClass, opponentClass, opponentName, outcome,
                deckNumber, matchNumber);
    }

    private String getTextValue(Element ele, String tagName) {
        String textVal = null;
        NodeList nl = ele.getElementsByTagName(tagName);
        if (nl != null && nl.getLength() > 0) {
            Element el = (Element) nl.item(0);
            textVal = el.getFirstChild().getNodeValue();
        }
        return textVal;
    }

    private int getIntValue(Element ele, String tagName) {
        return Integer.parseInt(getTextValue(ele, tagName));
    }

    private DeckClass getDeckClassValue(Element ele, String tagName) {
        String className = getTextValue(ele, tagName);
        return findCorrectClass(className);
    }

    private DeckClass findCorrectClass(String name) {
        for (DeckClass deckClass : classList) {
            if (deckClass.getName().equals(name)) {
                return deckClass;
            }
        }
        return null;
    }

    private Outcome getOutcomeValue(Element ele, String tagName) {
        String outcome = getTextValue(ele, tagName);
        if (outcome.equals(Outcome.WIN.getName())) {
            return Outcome.WIN;
        } else if (outcome.equals(Outcome.LOSS.getName())) {
            return Outcome.LOSS;
        } else {
            return Outcome.DISCONNECT;
        }
    }

    public List<Match> getMatches() {
        return matches;
    }
    
    
}
