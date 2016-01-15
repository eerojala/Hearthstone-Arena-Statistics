package xml;

import logic.RewardStatisticsKeeper;
import org.jdom.Attribute;
import org.jdom.Element;

/**
 * Class which writes reward statistics to a Xml file.
 */
public class RewardStatisticsWriter extends StatisticsWriter {

    /**
     * Creates a new RewardStatisticsWriter Object.
     * 
     * @param filePath File path to the Xml file.
     */
    public RewardStatisticsWriter(String filePath) {
        super(filePath, "WinAmounts", "WinAmount");
    }

    @Override
    public void writeContent(Object obj) {
        try {
            RewardStatisticsKeeper keeper = (RewardStatisticsKeeper) obj;
            for (int i = 0; i < 13; i++) {
                addWinAmountToDocument(i, keeper);
            }
        } catch (Exception e) {
            System.out.println("Writing Deck Win Statistics");
        }
    }

    private void addWinAmountToDocument(int wins, RewardStatisticsKeeper keeper) {
        Element element = new Element(childName);
        element.setAttribute(new Attribute("id", "" + wins));
        element.addContent(new Element("AmountOfDecks").setText("" + keeper.getDecksByWins(wins)));
        element.addContent(new Element("Dust").setText("" + keeper.getDustByWins(wins)));
        element.addContent(new Element("Gold").setText("" + keeper.getGoldByWins(wins)));
        element.addContent(new Element("ExtraPacks").setText("" + keeper.getExtraPacksByWins(wins)));
        element.addContent(new Element("RegularCards").setText("" + keeper.getRegularCardsByWins(wins)));
        element.addContent(new Element("GoldCards").setText("" + keeper.getGoldCardsByWins(wins)));
        doc.getRootElement().addContent(element);
        addToFile();
    }

    @Override
    public void updateSpecific(Object key, Object keeper) {
        try {
            int wins = (Integer) key;
            RewardStatisticsKeeper statKeeper = (RewardStatisticsKeeper) keeper;
            remove("" + wins);
            addWinAmountToDocument(wins, statKeeper);
        } catch (Exception e) {
            
        }
    }
}
