package Xml;

import domain.Match;
import java.util.ArrayList;
import java.util.List;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;

public class MatchWriter extends XmlWriter {

    public MatchWriter(String filePath) {
        super(filePath, "Matches", "Match");
    }

    @Override
    public void addContent(Document doc, Object obj) {
        try {
            Match match = (Match) obj;
            Element element = new Element("Match");
            element.setAttribute(new Attribute("id", match.getDeckNumber() + "." + match.getMatchNumber()));
            element.addContent(new Element("OpponentClass").setText(match.getOpponentDeckClass().getName()));
            element.addContent(new Element("OpponentName").setText(match.getOpponentName()));
            element.addContent(new Element("Outcome").setText(match.getOutcome().getName()));
            element.addContent(new Element("WentFirst").setText("" + match.wentFirst()));
            doc.getRootElement().addContent(element);
            addToFile(doc);
        } catch (Exception e) {
            
        }
    }

    public void removeMatchesFromASpecificDeck(Document doc, int deckNumber) {
        List<Element> children = doc.getRootElement().getChildren();
        List<Element> removeThese = new ArrayList();
        for (Element child : children) {
            String temp = "" + child.getAttributeValue("id").charAt(0);
            if (temp.equals("" + deckNumber)) {
                removeThese.add(child);
            }
        }
        removeMatches(doc.getRootElement(), removeThese);
        addToFile(doc);
    }

    private void removeMatches(Element root, List<Element> removeThese) {
        for (Element child : removeThese) {
            root.removeContent(child);
        }
    }

}
