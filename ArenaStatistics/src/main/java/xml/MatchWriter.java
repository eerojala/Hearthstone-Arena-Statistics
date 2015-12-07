package xml;

import domain.Match;
import java.util.ArrayList;
import java.util.List;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;

public class MatchWriter extends XmlWriter {

    public MatchWriter(String filepath) {
        super(filepath, "Matches", "Match");
    }

    @Override
    public void writeContent(Object obj) {
        try {
            Match match = (Match) obj;
            Element element = new Element(childName);
            element.setAttribute(new Attribute("id", match.getDeckNumber() + "." + match.getMatchNumber()));
            element.addContent(new Element("PlayerClass").setText(match.getPlayerClass().getName()));
            element.addContent(new Element("OpponentClass").setText(match.getOpponentClass().getName()));
            element.addContent(new Element("OpponentName").setText(match.getOpponentName()));
            element.addContent(new Element("Outcome").setText(match.getOutcome().getName()));
            element.addContent(new Element("WentFirst").setText("" + match.wentFirst()));
            doc.getRootElement().addContent(element);
            addToFile();
        } catch (Exception e) {
            System.out.println("Writing match to file failed");
        }
    }
    

//    public void removeMatchesFromASpecificDeck(Document doc, int deckNumber) {
//        List<Element> children = doc.getRootElement().getChildren();
//        List<Element> removeThese = new ArrayList();
//        for (Element child : children) {
//            String temp = "" + child.getAttributeValue("id").charAt(0);
//            if (temp.equals("" + deckNumber)) {
//                removeThese.add(child);
//            }
//        }
//        removeMatches(doc.getRootElement(), removeThese);
//        addToFile(doc);
//    }

//    private void removeMatches(Element root, List<Element> removeThese) {
//        for (Element child : removeThese) {
//            root.removeContent(child);
//        }
//    }

}
