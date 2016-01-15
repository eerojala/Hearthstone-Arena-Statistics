package xml;

import domain.Match;
import org.jdom.Attribute;
import org.jdom.Element;

/**
 * Match which writes the data of the current deck's matches to a Xml file.
 */
public class MatchWriter extends XmlWriter {

    /**
     * Creates a new MatchWriter Object.
     * 
     * @param filePath File path to the Xml file.
     */
    public MatchWriter(String filePath) {
        super(filePath, "Matches", "Match");
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
}
