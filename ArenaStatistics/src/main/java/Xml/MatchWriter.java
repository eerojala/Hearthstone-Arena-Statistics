
package Xml;

import domain.Match;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;

public class MatchWriter extends XmlWriter{

    public MatchWriter(String filePath) {
        super(filePath, "Matches", "Match");
    }

    @Override
    public void addContent(Document doc, Object obj) {
        Match match = (Match) obj;
        Element element = new Element("Match");
        element.setAttribute(new Attribute("id", match.getDeckNumber() + "." + match.getMatchNumber()));
        element.addContent(new Element("OpponentClass").setText(match.getOpponentClass().getName()));
        element.addContent(new Element("OpponentName").setText(match.getOpponentName()));
        element.addContent(new Element("Outcome").setText(match.getOutcome().getName()));
        element.addContent(new Element("WentFirst").setText("" + match.wentFirst()));        
        doc.getRootElement().addContent(element); 
        addToFile(doc);
    }
    
}
