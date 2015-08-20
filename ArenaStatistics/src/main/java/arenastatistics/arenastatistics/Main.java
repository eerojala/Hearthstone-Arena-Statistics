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
        ClassVSClassStatisticsParser parser;
        ClassVSClassStatisticsKeeper keeper;
        DeckClassPair rVSpr;
        DeckClassPair paVSwarr;
        parser = new ClassVSClassStatisticsParser("src/main/resources/ClassVSClassStatisticsParseTest.xml");
        parser.addValues();
        keeper = parser.getKeeper();
        rVSpr = new DeckClassPair(DeckClass.ROGUE, DeckClass.PRIEST);
        paVSwarr = new DeckClassPair(DeckClass.PALADIN, DeckClass.WARRIOR);
    }
}
