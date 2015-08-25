
package Xml;

import domain.DeckClass;
import logic.DeckClassStatisticsKeeper;
import org.jdom.Document;
import org.jdom.Element;

public class DeckClassStatisticsParser extends StatisticsParser{
    private final DeckClassStatisticsKeeper keeper;
    
    public DeckClassStatisticsParser(String filepath) {
        super(filepath, "Class", "Classes");
        keeper = new DeckClassStatisticsKeeper();
    }

    
    public DeckClassStatisticsParser(Document doc) {
        super(doc, "Class");
        keeper = new DeckClassStatisticsKeeper();
    }

    @Override
    protected void setStatistics(Element element) {
        DeckClass dc = DeckClass.parseDeckClass(getID(element));
        keeper.setDecksAsClass(dc, getIntValue(element, "AmountOfDecks"));
        keeper.setWinsAsClass(dc, getIntValue(element, "Wins"));
        keeper.updateDoubleMaps(dc);
    }

    public DeckClassStatisticsKeeper getKeeper() {
        return keeper;
    }
}
