package Xml;

import logic.DeckWinStatisticsKeeper;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;

public class DeckWinStatisticsWriter extends StatisticsWriter {

    public DeckWinStatisticsWriter(String filepath) {
        super(filepath, "WinAmounts", "WinAmount");
    }

    @Override
    public void writeContent(Document doc, Object obj) {
        try {
            DeckWinStatisticsKeeper keeper = (DeckWinStatisticsKeeper) obj;
            for (int i = 0; i < 13; i++) {
                addWinAmountToDocument(doc, i, keeper);
            }
        } catch (Exception e) {
            System.out.println("Writing Deck Win Statistics");
        }
    }

    private void addWinAmountToDocument(Document doc, int wins, DeckWinStatisticsKeeper keeper) {
        Element element = new Element(childName);
        element.setAttribute(new Attribute("id", "" + wins));
        element.addContent(new Element("AmountOfDecks").setText("" + keeper.getDecksByWins(wins)));
        element.addContent(new Element("Dust").setText("" + keeper.getDustByWins(wins)));
        element.addContent(new Element("Gold").setText("" + keeper.getGoldByWins(wins)));
        element.addContent(new Element("ExtraPacks").setText("" + keeper.getExtraPacksByWins(wins)));
        element.addContent(new Element("RegularCards").setText("" + keeper.getRegularCardsByWins(wins)));
        element.addContent(new Element("GoldCards").setText("" + keeper.getGoldCardsByWins(wins)));
        doc.getRootElement().addContent(element);
        addToFile(doc);
    }

    @Override
    public void updateSpecific(Document doc, Object key, Object keeper) {
        try {
            int wins = (Integer) key;
            DeckWinStatisticsKeeper statKeeper = (DeckWinStatisticsKeeper) keeper;
            remove(doc, "" + wins);
            addWinAmountToDocument(doc, wins, statKeeper);
        } catch (Exception e) {
            
        }
    }
}
