package arenastatistics.arenastatistics;

import Xml.*;
import domain.*;
import java.util.*;
import logic.*;
import org.jdom.*;
import util.Mapper;
import util.TestForLoop;

public class Main {

    public static void main(String[] args) {
        StatisticsWriter writer;
        DeckWinStatisticsKeeper keeper1;
        DeckWinStatisticsKeeper keeper2;
        DeckWinStatisticsParser parser;
        String filepath;
        Document doc;
        filepath = "src/main/resources/DeckWinStatisticsWriteTest.xml";
        writer = new DeckWinStatisticsWriter(filepath);
        doc = DocumentBuilder.buildDocument(filepath);
        keeper1 = new DeckWinStatisticsKeeper();
        keeper1.setDecksByWins(1, 7);
        keeper1.setDustByWins(1, 60);
        keeper1.setGoldByWins(1, 100);
        keeper1.setExtraPacksByWins(1, 0);
        keeper1.setRegularCardsByWins(1, 2);
        keeper1.setGoldCardsByWins(1, 1);
    }
}
