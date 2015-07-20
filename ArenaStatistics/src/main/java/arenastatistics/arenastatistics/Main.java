package arenastatistics.arenastatistics;

import Xml.DocumentBuilder;
import Xml.MatchParser;
import Xml.MatchWriter;
import domain.DeckClass;
import domain.Match;
import domain.Outcome;
import org.jdom.Document;

public class Main {

    public static void main(String[] args) {
//        MatchWriter writer = new MatchWriter("src/main/resources/MatchWriteTest.xml");
//        Match match1 = new Match(DeckClass.WARLOCK, DeckClass.PALADIN, "Dennis",
//                Outcome.DISCONNECT, true, 1, 1);
//        Document doc = DocumentBuilder.buildDocument("src/main/resources/MatchWriteTest.xml");
//        writer.addContent(doc, match1);
////        writer.removeLatest(doc);
////        writer.removeAll(doc);
////        writer.remove(doc, "1.1");
////        MatchParser parser = new MatchParser(doc);
////        Match match = parser.getMatches().get(0);
         MatchParser parser = new MatchParser("src/main/resources/MatchParseTest.xml");
        
    }

}
