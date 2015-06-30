package logic;

import domain.ArenaDeck;
import domain.DeckClass;
import domain.Match;
import domain.Outcome;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class XmlParser {

    private final List<DeckClass> classList;
    private final List<Match> matches;
    private final HashMap<Integer, ArenaDeck> decks;

    public XmlParser(String fileName) {
        matches = new ArrayList();
        decks = new HashMap();
        classList = new ArrayList();
        initializeClassList();
        parseXmlFile(fileName);
    }

    private void initializeClassList() {
        classList.add(DeckClass.DRUID);
        classList.add(DeckClass.HUNTER);
        classList.add(DeckClass.MAGE);
        classList.add(DeckClass.PALADIN);
        classList.add(DeckClass.PRIEST);
        classList.add(DeckClass.ROGUE);
        classList.add(DeckClass.SHAMAN);
        classList.add(DeckClass.WARLOCK);
        classList.add(DeckClass.WARRIOR);
    }

    private void parseXmlFile(String fileName) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            parseDocument(db.parse(new File(fileName)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseDocument(Document dom) {
        Element docEle = dom.getDocumentElement();
        NodeList nl = docEle.getElementsByTagName("Match");
        if (nl != null && nl.getLength() > 0) {
            for (int i = 0; i < nl.getLength(); i++) {
                Element el = (Element) nl.item(i);
                createMatch(el);
            }
        }
    }

    private void createMatch(Element matchEl) {
        DeckClass playerClass = getDeckClassValue(matchEl, "PlayerClass");
        DeckClass opponentClass = getDeckClassValue(matchEl, "OpponentClass");
        String opponentName = getTextValue(matchEl, "OpponentName");
        Outcome outcome = getOutcomeValue(matchEl, "Outcome");
        boolean wentFirst = getBooleanValue(matchEl, "WentFirst");
        int deckNumber = getIntValue(matchEl, "DeckNumber");
        int matchNumber = getIntValue(matchEl, "MatchNumber");
        Match match = new Match(playerClass, opponentClass, opponentName, outcome,
                wentFirst, deckNumber, matchNumber);
        matches.add(match);
        addMatchToDeck(match);
    }

    private void addMatchToDeck(Match match) {
        int deckNumber = match.getDeckNumber();
        ArenaDeck deck;
        DeckHandler handler = new DeckHandler();
        if (decks.keySet().contains(match.getDeckNumber())) {
            deck = decks.get(deckNumber);
        } else {
            deck = new ArenaDeck(match.getPlayerClass(), deckNumber);
            decks.put(deckNumber, deck);
        }
        handler.setDeck(deck);
        handler.addMatch(match);
    }

    private String getTextValue(Element ele, String tagName) {
        String textVal = null;
        NodeList nodeList = ele.getElementsByTagName(tagName);
        if (nodeList != null && nodeList.getLength() > 0) {
            Element element = (Element) nodeList.item(0);
            textVal = element.getFirstChild().getNodeValue();
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

    private boolean getBooleanValue(Element ele, String tagName) {
        return getTextValue(ele, tagName).equals("Yes");
    }

    public List<Match> getMatches() {
        return matches;
    }

    public HashMap<Integer, ArenaDeck> getDecks() {
        return decks;
    }

}
