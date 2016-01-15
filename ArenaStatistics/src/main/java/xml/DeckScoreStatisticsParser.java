
package xml;

import domain.DeckClass;
import logic.DeckScoreStatisticsKeeper;
import org.jdom.Document;
import org.jdom.Element;

/**
 * Class which parses deck score statistics from a Xml file.
 */
public class DeckScoreStatisticsParser extends StatisticsParser{
    private final DeckScoreStatisticsKeeper keeper;
    
    /**
     * Creates a new DeckScoreStatisticsParser Object.
     * 
     * @param filePath File path to the Xml file.
     */
    public DeckScoreStatisticsParser(String filePath) {
        super(filePath, "Class", "Classes");
        keeper = new DeckScoreStatisticsKeeper();
    }

    /**
     * Creates a new DeckScoreStatisticsParser Object.
     * 
     * @param doc Document representation of the Xml document.
     */
    public DeckScoreStatisticsParser(Document doc) {
        super(doc, "Class");
        keeper = new DeckScoreStatisticsKeeper();
    }

    @Override
    protected void setStatistics(Element element) {
        DeckClass dc = DeckClass.parseDeckClass(getID(element));
        setDecksAsClassWithXWins(element, dc);
        keeper.updateDoubleMaps(dc);
    }
    
    private void setDecksAsClassWithXWins(Element element, DeckClass dc) {
        for (int i = 0; i < 13; i++) {
            keeper.setDecksAsClassWithXWins(dc, i, getIntValue(element.getChild("Decks"), "Wins"+i));
        }
    }

    @Override
    public Object getParsedObject() {
        return keeper;
    }
    
    
}
