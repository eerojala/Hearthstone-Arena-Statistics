package xml;


import domain.DeckClass;
import logic.ClassStatisticsKeeper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MatchStatisticsWriterTest {

    StatisticsWriter writer;
    ClassStatisticsKeeper keeper1;
    ClassStatisticsKeeper keeper2;
    MatchStatisticsParser parser;
    String filepath;
    final DeckClass rogue;
    final DeckClass paladin;

    public MatchStatisticsWriterTest() {
        rogue = DeckClass.ROGUE;
        paladin = DeckClass.PALADIN;
        filepath = "src/main/resources/xmltestfiles/MatchStatisticsWriteTest.xml";
        writer = new MatchStatisticsWriter(filepath);
        keeper1 = new ClassStatisticsKeeper();

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        setClass1(rogue);
        setClass2(paladin);
        writer.writeContent(keeper1);
        keeper1 = parseToKeeper();
    }

    private void setClass1(DeckClass dc) {
        keeper1.setMatchesAsClass1st(dc, 54);
        keeper1.setMatchesAsClass2nd(dc, 25);
        keeper1.setMatchesVSClass1st(dc, 87);
        keeper1.setMatchesVSClass2nd(dc, 22);
        keeper1.setWinsAsClass1st(dc, 35);
        keeper1.setWinsAsClass2nd(dc, 4);
        keeper1.setWinsVSClass1st(dc, 61);
        keeper1.setWinsVSClass2nd(dc, 11);
        keeper1.setLossesAsClass1st(dc, 19);
        keeper1.setLossesAsClass2nd(dc, 14);
        keeper1.setLossesVSClass1st(dc, 26);
        keeper1.setLossesVSClass2nd(dc, 3);
    }

    private void setClass2(DeckClass dc) {
        keeper1.setMatchesAsClass1st(dc, 105);
        keeper1.setMatchesAsClass2nd(dc, 55);
        keeper1.setMatchesVSClass1st(dc, 99);
        keeper1.setMatchesVSClass2nd(dc, 71);
        keeper1.setWinsAsClass1st(dc, 50);
        keeper1.setWinsAsClass2nd(dc, 16);
        keeper1.setWinsVSClass1st(dc, 33);
        keeper1.setWinsVSClass2nd(dc, 66);
        keeper1.setLossesAsClass1st(dc, 48);
        keeper1.setLossesAsClass2nd(dc, 39);
        keeper1.setLossesVSClass1st(dc, 60);
        keeper1.setLossesVSClass2nd(dc, 5);
    }

    private ClassStatisticsKeeper parseToKeeper() {
        parse();
        return parser.getKeeper();
    }

    private void parse() {
        parser = new MatchStatisticsParser(writer.getDoc());
        parser.addValues();
    }

    @After
    public void tearDown() {
        writer.removeAll();
    }

    @Test
    public void amount_of_classes_is_correct() {
        assertEquals(9, parser.getChildlist().size());
    }
    @Test
    public void matches_as_class_1st_is_correct1() {
        assertEquals(54, keeper1.getMatchesAsClass1st(rogue));
    }

    @Test
    public void matches_as_class_1st_is_correct2() {
        assertEquals(105, keeper1.getMatchesAsClass1st(paladin));
    }

    @Test
    public void matches_as_class_2nd_is_correct1() {
        assertEquals(25, keeper1.getMatchesAsClass2nd(rogue));
    }

    @Test
    public void matches_as_class_2nd_is_correct2() {
        assertEquals(55, keeper1.getMatchesAsClass2nd(paladin));
    }

    @Test
    public void matches_vs_class_1st_is_correct1() {
        assertEquals(87, keeper1.getMatchesVSClass1st(rogue));
    }

    @Test
    public void matches_vs_class_1st_is_correct2() {
        assertEquals(99, keeper1.getMatchesVSClass1st(paladin));
    }

    @Test
    public void matches_vs_class_2nd_is_correct1() {
        assertEquals(22, keeper1.getMatchesVSClass2nd(rogue));
    }

    @Test
    public void matches_vs_class_2nd_is_correct2() {
        assertEquals(71, keeper1.getMatchesVSClass2nd(paladin));
    }

    @Test
    public void wins_as_class_1st_is_correct1() {
        assertEquals(35, keeper1.getWinsAsClass1st(rogue));
    }

    @Test
    public void wins_as_class_1st_is_correct2() {
        assertEquals(50, keeper1.getWinsAsClass1st(paladin));
    }

    @Test
    public void wins_as_class_2nd_is_correct1() {
        assertEquals(4, keeper1.getWinsAsClass2nd(rogue));
    }

    @Test
    public void wins_as_class_2nd_is_correct2() {
        assertEquals(16, keeper1.getWinsAsClass2nd(paladin));
    }

    @Test
    public void wins_vs_class_1st_is_correct1() {
        assertEquals(61, keeper1.getWinsVSClass1st(rogue));
    }

    @Test
    public void wins_vs_class_1st_is_correct2() {
        assertEquals(33, keeper1.getWinsVSClass1st(paladin));
    }

    @Test
    public void wins_vs_class_2nd_is_correct1() {
        assertEquals(11, keeper1.getWinsVSClass2nd(rogue));
    }

    @Test
    public void wins_vs_class_2nd_is_correct2() {
        assertEquals(66, keeper1.getWinsVSClass2nd(paladin));
    }

    @Test
    public void losses_as_class_1st_is_correct1() {
        assertEquals(19, keeper1.getLossesAsClass1st(rogue));
    }

    @Test
    public void losses_as_class_1st_is_correct2() {
        assertEquals(48, keeper1.getLossesAsClass1st(paladin));
    }

    @Test
    public void losses_as_class_2nd_is_correct1() {
        assertEquals(14, keeper1.getLossesAsClass2nd(rogue));
    }

    @Test
    public void losses_as_class_2nd_is_correct2() {
        assertEquals(39, keeper1.getLossesAsClass2nd(paladin));
    }

    @Test
    public void losses_vs_class_1st_is_correct1() {
        assertEquals(26, keeper1.getLossesVSClass1st(rogue));
    }

    @Test
    public void losses_vs_class_1st_is_correct2() {
        assertEquals(60, keeper1.getLossesVSClass1st(paladin));
    }

    @Test
    public void losses_vs_class_2nd_is_correct1() {
        assertEquals(3, keeper1.getLossesVSClass2nd(rogue));
    }

    @Test
    public void losses_vs_class_2nd_is_correct2() {
        assertEquals(5, keeper1.getLossesVSClass2nd(paladin));
    }

    @Test
    public void win_percentage_as_class_1st_is_correct1() {
        assertEquals(0.648, keeper1.getWinPerAsClass1st(rogue), 0.001);
    }

    @Test
    public void win_percentage_as_class_1st_is_correct2() {
        assertEquals(0.51, keeper1.getWinPerAsClass1st(paladin), 0.01);
    }

    @Test
    public void win_percentage_as_class_2nd_is_correct1() {
        assertEquals(0.222, keeper1.getWinPerAsClass2nd(rogue), 0.001);
    }

    @Test
    public void win_percentage_as_class_2nd_is_correct2() {
        assertEquals(0.29, keeper1.getWinPerAsClass2nd(paladin), 0.001);
    }

    @Test
    public void win_percentage_vs_class_1st_is_correct1() {
        assertEquals(0.7, keeper1.getWinPerVSClass1st(rogue), 0.01);
    }

    @Test
    public void win_percentage_vs_class_1st_is_correct2() {
        assertEquals(0.354, keeper1.getWinPerVSClass1st(paladin), 0.001);
    }

    @Test
    public void win_percentage_vs_class_2nd_is_correct1() {
        assertEquals(0.785, keeper1.getWinPerVSClass2nd(rogue), 0.001);
    }

    @Test
    public void win_percentage_vs_class_2nd_is_correct2() {
        assertEquals(0.929, keeper1.getWinPerVSClass2nd(paladin), 0.001);
    }

    @Test
    public void update_specific_works_correctly() {
        keeper1.setMatchesAsClass1st(paladin, 333);
        writer.updateSpecific(paladin, keeper1);
        keeper2 = parseToKeeper();
        assertEquals(333, keeper2.getMatchesAsClass1st(paladin));
    }
    
    @Test
    public void update_specific_does_not_affect_others() {
        writer.updateSpecific(paladin, keeper1);
        keeper2 = parseToKeeper();
        assertEquals(54, keeper2.getMatchesAsClass1st(rogue));
    }
    
    @Test
    public void update_specific_does_not_duplicate_specific() {
        writer.updateSpecific(paladin, keeper1);
        parse();
        assertEquals(9, parser.getChildlist().size());
    }
    
    @Test
    public void update_specific_does_nothing_if_wrong_objects_are_given() {
        keeper1.setMatchesAsClass1st(paladin, 1111);
        writer.updateSpecific("asdf", keeper1);
        keeper2 = parseToKeeper();
        assertEquals(105, keeper2.getMatchesAsClass1st(paladin));
    }
}
