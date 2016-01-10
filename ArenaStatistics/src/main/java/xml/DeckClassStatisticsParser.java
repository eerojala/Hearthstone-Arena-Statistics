
package xml;

import domain.DeckClass;
import logic.DeckScoreStatisticsKeeper;
import org.jdom.Document;
import org.jdom.Element;

public class DeckClassStatisticsParser extends StatisticsParser{
    private final DeckScoreStatisticsKeeper keeper;
    
    public DeckClassStatisticsParser(String filepath) {
        super(filepath, "Class", "Classes");
        keeper = new DeckScoreStatisticsKeeper();
    }

    
    public DeckClassStatisticsParser(Document doc) {
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

    public DeckScoreStatisticsKeeper getKeeper() {
        return keeper;
    }
}
