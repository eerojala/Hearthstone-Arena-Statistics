package arenastatistics.arenastatistics;

import Xml.*;
import domain.*;
import gui.MainGUI;
import gui.StartUpGUI;
import java.util.*;
import javax.swing.SwingUtilities;
import logic.*;
import org.jdom.*;
import util.DocumentBuilder;
import util.Mapper;
import util.StatisticsHelper;
import util.TestForLoop;

public class Main {

    public static void main(String[] args) {
        StartUpGUI gui = new StartUpGUI();
        SwingUtilities.invokeLater(gui);
        gui.setVisible(true);
//        MatchWriter writer;
//        MatchParser parser;
//        Document doc;
//        Match match;
//        Match match1;
//        Match match2;
//        Match match3;
//        Match match4;
//        Match match5;
//        Match match6;
//        Match match7;
//        Match match8;
//        Match match9;
//        String filePath;
//        List<Match> matches;
//        filePath = "src/main/resources/MatchWriteTest.xml";
//        writer = new MatchWriter(filePath);
//        match1 = new Match(DeckClass.DRUID, DeckClass.PALADIN, "Dennis", Outcome.DISCONNECT, true, 1, 1);
//        match2 = new Match(DeckClass.HUNTER, DeckClass.ROGUE, "UNKNOWN", Outcome.WIN, false, 2, 1);
//        match3 = new Match(DeckClass.MAGE, DeckClass.HUNTER, "öööö", Outcome.LOSS, true, 3, 1);
//        match4 = new Match(DeckClass.SHAMAN, DeckClass.DRUID, "weweq", Outcome.TIE, false, 4, 1);
//        match5 = new Match(DeckClass.WARLOCK, DeckClass.WARRIOR, "", Outcome.WIN, true, 5, 1);
//        match6 = new Match(DeckClass.ROGUE, DeckClass.SHAMAN, "", Outcome.LOSS, false, 6, 1);
//        match7 = new Match(DeckClass.WARRIOR, DeckClass.MAGE, "fafasdf", Outcome.DISCONNECT, true, 7, 1);
//        match8 = new Match(DeckClass.PALADIN, DeckClass.WARLOCK, "fr3fseew3", Outcome.WIN, false, 8, 1);
//        match9 = new Match(DeckClass.PALADIN, DeckClass.PRIEST, "332424", Outcome.LOSS, true, 9, 1);
//        doc = DocumentBuilder.buildDocument(filePath);
//        writer.writeContent(doc, match1);
//        writer.writeContent(doc, match2);
//        writer.writeContent(doc, match3);
//        writer.writeContent(doc, match4);
//        writer.writeContent(doc, match5);
//        writer.writeContent(doc, match6);
//        writer.writeContent(doc, match7);
//        writer.writeContent(doc, match8);
//        writer.writeContent(doc, match9);
//        matches = new ArrayList();
//        Map<String, List<Match>> map = parser.getArchiver().getArchive().getMatchesByOpponent();
//        for (String name : map.keySet()) {
//            for (Match m : map.get(name)) {
//                matches.add(m);
//            }
//        }
//        Collections.sort(matches);
    }
}
