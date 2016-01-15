package xml;

import domain.DeckClass;
import domain.Matchup;
import logic.MatchupStatisticsKeeper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClassVSClassStatisticsXmlTest {

    private StatisticsWriter writer;
    private MatchupStatisticsKeeper keeper1;
    private MatchupStatisticsKeeper keeper2;
    private StatisticsParser parser;
    private static final String filepath = "src/main/resources/xmltestfiles/ClassVSClassStatisticsXmlTest.xml";
    private static final Matchup mVSr = new Matchup(DeckClass.MAGE, DeckClass.ROGUE);
    private static final Matchup sVSh = new Matchup(DeckClass.SHAMAN, DeckClass.HUNTER);

    public ClassVSClassStatisticsXmlTest() {
        writer = new MatchupStatisticsWriter(filepath);
        keeper1 = new MatchupStatisticsKeeper();
        setDcp1(mVSr);
        setDcp2(sVSh);
        writer.writeContent(keeper1);
        parseToKeeper1();
    }

    private void parseToKeeper1() {
        parse();
        keeper1 = (MatchupStatisticsKeeper) parser.getParsedObject();
    }

    private void parse() {
        parser = new MatchupStatisticsParser(writer.getDoc());
        parser.addValues();
    }

    private void parseToKeeper2() {
        parse();
        keeper2 = (MatchupStatisticsKeeper) parser.getParsedObject();;
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    private void setDcp1(Matchup dcp) {
        keeper1.setMatchesInMatchup1st(dcp, 34);
        keeper1.setMatchesInMatchup2nd(dcp, 156);
        keeper1.setWinsInMatchup1st(dcp, 21);
        keeper1.setWinsInMatchup2nd(dcp, 108);
        keeper1.setLossesInMatchup1st(dcp, 13);
        keeper1.setLossesInMatchup2nd(dcp, 25);
    }

    private void setDcp2(Matchup dcp) {
        keeper1.setMatchesInMatchup1st(dcp, 66);
        keeper1.setMatchesInMatchup2nd(dcp, 179);
        keeper1.setWinsInMatchup1st(dcp, 34);
        keeper1.setWinsInMatchup2nd(dcp, 146);
        keeper1.setLossesInMatchup1st(dcp, 20);
        keeper1.setLossesInMatchup2nd(dcp, 33);
    }

    @After
    public void tearDown() {
        writer.removeAll();
    }

    @Test
    public void matches_1st_is_correct1() {
        assertEquals(34, keeper1.getMatchesInMatchup1st(mVSr));
    }

    @Test
    public void matches_1st_is_correct2() {
        assertEquals(66, keeper1.getMatchesInMatchup1st(sVSh));
    }

    @Test
    public void matches_2nd_is_correct1() {
        assertEquals(156, keeper1.getMatchesInMatchup2nd(mVSr));
    }

    @Test
    public void matches_2nd_is_correct2() {
        assertEquals(179, keeper1.getMatchesInMatchup2nd(sVSh));
    }

    @Test
    public void wins_1st_is_correct1() {
        assertEquals(21, keeper1.getWinsInMatchup1st(mVSr));
    }

    @Test
    public void wins_1st_is_correct2() {
        assertEquals(34, keeper1.getWinsInMatchup1st(sVSh));
    }

    @Test
    public void wins_2nd_is_correct1() {
        assertEquals(108, keeper1.getWinsInMatchup2nd(mVSr));
    }

    @Test
    public void wins_2nd_is_correct2() {
        assertEquals(146, keeper1.getWinsInMatchup2nd(sVSh));
    }

    @Test
    public void losses_1st_is_correct1() {
        assertEquals(13, keeper1.getLossesInMatchup1st(mVSr));
    }

    @Test
    public void losses_1st_is_correct2() {
        assertEquals(20, keeper1.getLossesInMatchup1st(sVSh));
    }

    @Test
    public void losses_2nd_is_correct1() {
        assertEquals(25, keeper1.getLossesInMatchup2nd(mVSr));
    }

    @Test
    public void losses_2nd_is_correct2() {
        assertEquals(33, keeper1.getLossesInMatchup2nd(sVSh));
    }

    @Test
    public void win_percentage_1st_is_correct1() {
        assertEquals(0.617, keeper1.getMatchupWinRatio1st(mVSr), 0.001);
    }

    @Test
    public void win_percentage_1st_is_correct2() {
        assertEquals(0.629, keeper1.getMatchupWinRatio1st(sVSh), 0.001);
    }

    @Test
    public void win_percentage_2nd_is_correct1() {
        assertEquals(0.812, keeper1.getMatchupWinRatio2nd(mVSr), 0.001);
    }

    @Test
    public void win_percentage_2nd_is_correct2() {
        assertEquals(0.815, keeper1.getMatchupWinRatio2nd(sVSh), 0.001);
    }

    @Test
    public void update_specific_works_correctly() {
        keeper1.setMatchesInMatchup1st(mVSr, 100);
        writer.updateSpecific(mVSr, keeper1);
        parseToKeeper2();
        assertEquals(100, keeper2.getMatchesInMatchup1st(mVSr));
    }

    @Test
    public void update_specific_doesnt_clear_other_classPairs() {
        writer.updateSpecific(mVSr, keeper1);
        parseToKeeper2();
        assertEquals(66, keeper2.getMatchesInMatchup1st(sVSh));
    }

    @Test
    public void update_specific_doesnt_duplicate_specific() {
        writer.updateSpecific(mVSr, keeper1);
        parseToKeeper2();
        assertEquals(81, parser.getChildlist().size());
    }

    @Test
    public void update_specific_does_nothing_if_wrong_objects_are_given() {
        keeper1.setLossesInMatchup1st(mVSr, 1000);
        writer.updateSpecific("asdf", keeper1);
        parseToKeeper2();
        assertEquals(13, keeper2.getLossesInMatchup1st(mVSr));
    }

}
