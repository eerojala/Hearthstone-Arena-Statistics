//package Xml;
//
//import domain.DeckClass;
//import domain.Match;
//import domain.Outcome;
//import org.jdom.Document;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class MatchWriterTest {
//
//    XmlWriter writer;
//    MatchParser parser;
//    Document doc;
//    Match match1;
//    Match match2;
//    String filePath;
//    
//    public MatchWriterTest() {
//        filePath = "src/main/resources/MatchWriteTest.xml";
//        writer = new MatchWriter();
//        match1 = new Match(DeckClass.WARLOCK, DeckClass.PALADIN, "Dennis",
//                Outcome.DISCONNECT, true, 1, 1);
//        match2 = new Match(DeckClass.PRIEST, DeckClass.DRUID, "UNKNOWN",
//                Outcome.WIN, false, 2, 1);
//    }
//
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//        doc = DocumentBuilder.buildDocument(filePath);
//    }
//
//    @After
//    public void tearDown() {
//        writer.clearLatest(doc, filePath);
//    }
//
////    @Test
////    public void addContent_adds_a_match() {
////        writer.addContent(doc, filePath, match1);
////        parser = new MatchParser(doc);
////        Match match = parser.getMatches().get(0);
////        assertEquals(match, match1);
////    }
//}
