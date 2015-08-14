package logic;

import domain.Deck;
import domain.DeckClass;
import domain.DeckClassPair;
import domain.Match;
import domain.Outcome;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.DeckClassList;
import util.TestForLoop;

public class MatchStatisticsKeeperTest {

    MatchStatisticsKeeper keeper;
    boolean bool;
    List<DeckClass> dclist;
    DeckClassPair sVSm;
    DeckClassPair sVSd;
    DeckClassPair sVSpa;
    DeckClassPair prVSwarr;
    DeckClassPair sVSr;
    DeckClassPair rVSs;
    Match match1;
    Match match2;
    Match match3;
    Match match4;
    Match match5;
    Match match6;
    Match match7;
    Match match8;
    Match match9;
    Match match10;
    Match match11;

    public MatchStatisticsKeeperTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        keeper = new MatchStatisticsKeeper();
        Deck deck1 = new Deck(DeckClass.SHAMAN, 1);
        DeckHandler handler = new DeckHandler();
        handler.setDeck(deck1);
        match1 = new Match(DeckClass.MAGE, "", Outcome.WIN, true, 1, 1);
        handler.addMatch(match1);
        match2 = new Match(DeckClass.MAGE, "", Outcome.LOSS, false, 1, 2);
        handler.addMatch(match2);
        match3 = new Match(DeckClass.DRUID, "", Outcome.WIN, false, 1, 3);
        handler.addMatch(match3);
        match4 = new Match(DeckClass.PALADIN, "", Outcome.LOSS, true, 1, 4);
        handler.addMatch(match4);
        match5 = new Match(DeckClass.ROGUE, "", Outcome.DISCONNECT, true, 1, 5);
        handler.addMatch(match5);
        match6 = new Match(DeckClass.MAGE, "", Outcome.WIN, true, 1, 6);
        handler.addMatch(match6);
        match7 = new Match(DeckClass.MAGE, "", Outcome.LOSS, false, 1, 7);
        handler.addMatch(match7);
        match8 = new Match(DeckClass.DRUID, "", Outcome.WIN, false, 1, 8);
        handler.addMatch(match8);
        match9 = new Match(DeckClass.PALADIN, "", Outcome.LOSS, true, 1, 9);
        handler.addMatch(match9);
        Deck deck2 = new Deck(DeckClass.PRIEST, 2);
        handler.setDeck(deck2);
        match10 = new Match(DeckClass.WARRIOR, "", Outcome.LOSS, false, 2, 1);
        handler.addMatch(match10);
        match11 = new Match(DeckClass.WARLOCK, "", Outcome.TIE, true, 2, 2);
        handler.addMatch(match11);
        List<Deck> list = new ArrayList();
        list.add(deck1);
        list.add(deck2);
        keeper.addMatches(list);
        dclist = DeckClassList.getDeckClassList();
        sVSm = new DeckClassPair(DeckClass.SHAMAN, DeckClass.MAGE);
        sVSd = new DeckClassPair(DeckClass.SHAMAN, DeckClass.DRUID);
        sVSpa = new DeckClassPair(DeckClass.SHAMAN, DeckClass.PALADIN);
        prVSwarr = new DeckClassPair(DeckClass.PRIEST, DeckClass.WARRIOR);
        sVSr = new DeckClassPair(DeckClass.SHAMAN, DeckClass.ROGUE);
        rVSs = new DeckClassPair(DeckClass.ROGUE, DeckClass.SHAMAN);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void matches_as_class_going_1st_are_correct1() {
        assertEquals(5, keeper.getMatchesAsClass1st(DeckClass.SHAMAN));
    }

    @Test
    public void matches_as_class_going_1st_are_correct2() {
        bool = TestForLoop.zeroesInDcIntegerMap2ClassExceptions(keeper.getStatistics().getMatchesAsClass1st(), DeckClass.SHAMAN, DeckClass.PRIEST);
        assertTrue(bool);
    }

    @Test
    public void matches_as_class_going_2nd_are_correct1() {
        assertEquals(4, keeper.getMatchesAsClass2nd(DeckClass.SHAMAN));
    }

    @Test
    public void matches_as_class_going_2nd_are_correct2() {
        assertEquals(1, keeper.getMatchesAsClass2nd(DeckClass.PRIEST));
    }

    @Test
    public void matches_as_class_going_2nd_are_correct3() {
        bool = TestForLoop.zeroesInDcIntegerMap2ClassExceptions(keeper.getStatistics().getMatchesAsClass2nd(), DeckClass.PRIEST, DeckClass.SHAMAN);
        assertTrue(bool);
    }

    @Test
    public void matches_vs_class_going_1st_is_correct1() {
        assertEquals(2, keeper.getMatchesVSClass1st(DeckClass.MAGE));
    }

    @Test
    public void matches_vs_class_going_1st_is_correct2() {
        assertEquals(2, keeper.getMatchesVSClass1st(DeckClass.PALADIN));
    }

    @Test
    public void matches_vs_class_going_1st_is_correct3() {
        assertEquals(1, keeper.getMatchesVSClass1st(DeckClass.ROGUE));
    }

    @Test
    public void matches_vs_class_going_1st_is_correct4() {
        bool = TestForLoop.zeroesInDcIntegerMap4ClassExceptions(keeper.getStatistics().getMatchesVSClass1st(), DeckClass.MAGE,
                DeckClass.PALADIN, DeckClass.ROGUE, DeckClass.WARLOCK);
        assertTrue(bool);
    }

    @Test
    public void matches_vs_class_going_2nd_is_correct1() {
        assertEquals(2, keeper.getMatchesVSClass2nd(DeckClass.MAGE));
    }

    @Test
    public void matches_vs_class_going_2nd_is_correct2() {
        assertEquals(2, keeper.getMatchesVSClass2nd(DeckClass.DRUID));
    }

    @Test
    public void matches_vs_class_going_2nd_is_correct3() {
        assertEquals(1, keeper.getMatchesVSClass2nd(DeckClass.WARRIOR));
    }

    @Test
    public void matches_vs_class_going_2nd_is_correct4() {
        bool = TestForLoop.zeroesInDcIntegerMap3ClassExceptions(keeper.getStatistics().getMatchesVSClass2nd(), DeckClass.MAGE,
                DeckClass.DRUID, DeckClass.WARRIOR);
        assertTrue(bool);
    }

    @Test
    public void wins_as_class_going_1st_is_correct1() {
        assertEquals(2, keeper.getWinsAsClass1st(DeckClass.SHAMAN));
    }

    @Test
    public void wins_as_class_going_1st_is_correct2() {
        bool = TestForLoop.zeroesInDcIntegerMap1ClassException(keeper.getStatistics().getWinsAsClass1st(), DeckClass.SHAMAN);
        assertTrue(bool);
    }

    @Test
    public void wins_as_class_going_2nd_is_correct1() {
        assertEquals(2, keeper.getWinsAsClass2nd(DeckClass.SHAMAN));
    }

    @Test
    public void wins_as_class_going_2nd_is_correct2() {
        bool = TestForLoop.zeroesInDcIntegerMap1ClassException(keeper.getStatistics().getWinsAsClass2nd(), DeckClass.SHAMAN);
        assertTrue(bool);
    }

    @Test
    public void losses_as_class_going_1st_is_correct1() {
        assertEquals(2, keeper.getLossesAsClass1st(DeckClass.SHAMAN));
    }

    @Test
    public void losses_as_class_going_1st_is_correct2() {
        bool = TestForLoop.zeroesInDcIntegerMap1ClassException(keeper.getStatistics().getLossesAsClass1st(), DeckClass.SHAMAN);
        assertTrue(bool);
    }

    @Test
    public void losses_as_class_going_2nd_is_correct1() {
        assertEquals(2, keeper.getLossesAsClass2nd(DeckClass.SHAMAN));
    }

    @Test
    public void losses_as_class_going_2nd_is_correct2() {
        assertEquals(1, keeper.getLossesAsClass2nd(DeckClass.PRIEST));
    }

    @Test
    public void losses_as_class_going_2nd_is_correct3() {
        bool = TestForLoop.zeroesInDcIntegerMap2ClassExceptions(keeper.getStatistics().getLossesAsClass2nd(), DeckClass.SHAMAN, DeckClass.PRIEST);
        assertTrue(bool);
    }

    @Test
    public void wins_vs_class_going_1st_is_correct1() {
        assertEquals(2, keeper.getWinsVSClass1st(DeckClass.MAGE));
    }

    @Test
    public void wins_vs_class_going_1st_is_correct2() {
        bool = TestForLoop.zeroesInDcIntegerMap1ClassException(keeper.getStatistics().getWinsVSClass1st(), DeckClass.MAGE);
        assertTrue(bool);
    }

    @Test
    public void wins_vs_class_going_2nd_is_correct1() {
        assertEquals(2, keeper.getWinsVSClass2nd(DeckClass.DRUID));
    }

    @Test
    public void wins_vs_class_going_2nd_is_correct2() {
        bool = TestForLoop.zeroesInDcIntegerMap1ClassException(keeper.getStatistics().getWinsVSClass2nd(), DeckClass.DRUID);
        assertTrue(bool);
    }

    @Test
    public void losses_vs_class_going_1st_is_correct1() {
        assertEquals(2, keeper.getLossesVSClass1st(DeckClass.PALADIN));
    }

    @Test
    public void losses_vs_class_going_1st_is_correct2() {
        bool = TestForLoop.zeroesInDcIntegerMap1ClassException(keeper.getStatistics().getLossesVSClass1st(), DeckClass.PALADIN);
        assertTrue(bool);
    }

    @Test
    public void losses_vs_class_going_2nd_is_correct1() {
        assertEquals(2, keeper.getLossesVSClass2nd(DeckClass.MAGE));
    }

    @Test
    public void losses_vs_class_going_2nd_is_correct2() {
        assertEquals(1, keeper.getLossesVSClass2nd(DeckClass.WARRIOR));
    }

    @Test
    public void losses_vs_class_going_2nd_is_correct3() {
        bool = TestForLoop.zeroesInDcIntegerMap2ClassExceptions(keeper.getStatistics().getLossesVSClass2nd(), DeckClass.MAGE, DeckClass.WARRIOR);
        assertTrue(bool);
    }

    @Test
    public void matches_in_class_vs_class_going_1st_is_correct1() {
        assertEquals(2, keeper.getMatchesInClassVSClass1st(sVSm));
    }

    @Test
    public void matches_in_class_vs_class_going_1st_is_correct2() {
        assertEquals(2, keeper.getMatchesInClassVSClass1st(sVSpa));
    }

    @Test
    public void matches_in_class_vs_class_going_1st_is_correct3() {
        assertEquals(1, keeper.getMatchesInClassVSClass1st(sVSr));
    }

    @Test
    public void matches_in_class_vs_class_going_2nd_is_correct1() {
        assertEquals(2, keeper.getMatchesInClassVSClass2nd(sVSm));
    }

    @Test
    public void matches_in_class_vs_class_going_2nd_is_correct2() {
        assertEquals(2, keeper.getMatchesInClassVSClass2nd(sVSd));
    }

    @Test
    public void matches_in_class_vs_class_going_2nd_is_correct3() {
        assertEquals(1, keeper.getMatchesInClassVSClass2nd(prVSwarr));
    }

    @Test
    public void wins_in_class_vs_class_going_1st_is_correct1() {
        assertEquals(2, keeper.getWinsInClassVSClass1st(sVSm));
    }

    @Test
    public void wins_in_class_vs_class_going_1st_is_correct2() {
        bool = TestForLoop.zeroesInDcpIntegerMap1DcpException(keeper.getStatistics().getWinsInClassVSClass1st(), sVSm);
        assertTrue(bool);
    }

    @Test
    public void wins_in_class_vs_class_going_2nd_is_correct1() {
        assertEquals(2, keeper.getWinsInClassVSClass2nd(sVSd));
    }

    @Test
    public void wins_in_class_vs_class_going_2nd_is_correct2() {
        bool = TestForLoop.zeroesInDcpIntegerMap1DcpException(keeper.getStatistics().getWinsInClassVSClass2nd(), sVSd);
        assertTrue(bool);
    }

    @Test
    public void losses_in_class_vs_class_going_1st_is_correct1() {
        assertEquals(2, keeper.getLossesInClassVSClass1st(sVSpa));
    }

    @Test
    public void losses_in_class_vs_class_going_1st_is_correct2() {
        bool = TestForLoop.zeroesInDcpIntegerMap1DcpException(keeper.getStatistics().getLossesInClassVSClass1st(), sVSpa);
        assertTrue(bool);
    }

    @Test
    public void losses_in_class_vs_class_going_2nd_is_correct1() {
        assertEquals(2, keeper.getLossesInClassVSClass2nd(sVSm));
    }

    @Test
    public void losses_in_class_vs_class_going_2nd_is_correct2() {
        assertEquals(1, keeper.getLossesInClassVSClass2nd(prVSwarr));
    }

    @Test
    public void losses_in_class_vs_class_going_2nd_is_correct3() {
        bool = TestForLoop.zeroesInDcpIntegerMap2DcpExceptions(keeper.getStatistics().getLossesInClassVSClass2nd(),
                sVSm, prVSwarr);
        assertTrue(bool);
    }

    @Test
    public void win_percentage_as_class_going_1st_is_correct1() {
        assertEquals(0.5, keeper.getWinPerAsClass1st(DeckClass.SHAMAN), 0.05);
    }

    @Test
    public void win_percentage_as_class_going_1st_is_correct2() {
        bool = TestForLoop.zeroesInDcDoubleMap1ClassException(keeper.getStatistics().getWinPerAsClass1st(), DeckClass.SHAMAN);
        assertTrue(bool);
    }

    @Test
    public void win_percentage_as_class_going_2nd_is_correct1() {
        assertEquals(0.5, keeper.getWinPerAsClass2nd(DeckClass.SHAMAN), 0.05);
    }

    @Test
    public void win_percentage_as_class_going_2nd_is_correct2() {
        bool = TestForLoop.zeroesInDcDoubleMap1ClassException(keeper.getStatistics().getWinPerAsClass2nd(), DeckClass.SHAMAN);
        assertTrue(bool);
    }

    @Test
    public void win_percentage_vs_class_going_1st_is_correct1() {
        assertEquals(1, keeper.getWinPerVSClass1st(DeckClass.MAGE), 0.00001);
    }

    @Test
    public void win_percentage_vs_class_going_1st_is_correct2() {
        bool = TestForLoop.zeroesInDcDoubleMap1ClassException(keeper.getStatistics().getWinPerVSClass1st(), DeckClass.MAGE);
        assertTrue(bool);
    }

    @Test
    public void win_percentage_vs_class_going_2nd_is_correct1() {
        assertEquals(1, keeper.getWinPerVSClass2nd(DeckClass.DRUID), 0.0001);
    }

    @Test
    public void win_percentage_vs_class_going_2nd_is_correct2() {
        bool = TestForLoop.zeroesInDcDoubleMap1ClassException(keeper.getStatistics().getWinPerVSClass2nd(), DeckClass.DRUID);
    }

    @Test
    public void win_percentage_class_vs_class_going_1st_is_correct1() {
        assertEquals(1, keeper.getWinPerClassVSClass1st(sVSm), 0.0001);
    }

    @Test
    public void win_percentage_class_vs_class_going_1st_is_correct2() {
        bool = TestForLoop.zeroesInDcpDoubleMap1DcpException(keeper.getStatistics().getWinPerClassVSClass1st(), sVSm);
        assertTrue(bool);
    }


    @Test
    public void win_percentage_class_vs_class_going_second_is_correct1() {
        assertEquals(1, keeper.getWinPerClassVSClass2nd(sVSd), 0.00001);
    }

    @Test
    public void win_percentage_class_vs_class_going_second_is_correct2() {
        bool = TestForLoop.zeroesInDcpDoubleMap1DcpException(keeper.getStatistics().getWinPerClassVSClass2nd(), sVSd);
        assertTrue(bool);
    }

    @Test
    public void matches_as_class_total_is_correct1() {
        assertEquals(9, keeper.getMatchesAsClassTotal(DeckClass.SHAMAN));
    }

    @Test
    public void matches_as_class_total_is_correct2() {
        assertEquals(2, keeper.getMatchesAsClassTotal(DeckClass.PRIEST));
    }

    @Test
    public void matches_as_class_total_is_correct3() {
        assertEquals(0, keeper.getMatchesAsClassTotal(DeckClass.WARLOCK));
    }

    @Test
    public void matches_vs_class_total_is_correct1() {
        assertEquals(4, keeper.getMatchesVSClassTotal(DeckClass.MAGE));
    }

    @Test
    public void matches_vs_class_total_is_correct2() {
        assertEquals(2, keeper.getMatchesVSClassTotal(DeckClass.DRUID));
    }

    @Test
    public void matches_vs_class_total_is_correct3() {
        assertEquals(2, keeper.getMatchesVSClassTotal(DeckClass.PALADIN));
    }

    @Test
    public void matches_vs_class_total_is_correct4() {
        assertEquals(1, keeper.getMatchesVSClassTotal(DeckClass.ROGUE));
    }

    @Test
    public void matches_vs_class_total_is_correct5() {
        assertEquals(1, keeper.getMatchesVSClassTotal(DeckClass.WARRIOR));
    }

    @Test
    public void matches_vs_class_total_is_correct6() {
        assertEquals(1, keeper.getMatchesVSClassTotal(DeckClass.WARLOCK));
    }

    @Test
    public void matches_in_class_vs_class_total_is_correct1() {
        assertEquals(4, keeper.getMatchesInClassVSClassTotal(sVSm));
    }

    @Test
    public void matches_in_class_vs_class_total_is_correct2() {
        assertEquals(2, keeper.getMatchesInClassVSClassTotal(sVSd));
    }

    @Test
    public void matches_in_class_vs_class_total_is_correct3() {
        assertEquals(2, keeper.getMatchesInClassVSClassTotal(sVSpa));
    }

    @Test
    public void matches_in_class_vs_class_total_is_correct4() {
        assertEquals(1, keeper.getMatchesInClassVSClassTotal(sVSr));
    }

    @Test
    public void matches_in_class_vs_class_total_is_correct5() {
        assertEquals(1, keeper.getMatchesInClassVSClassTotal(prVSwarr));
    }

    @Test
    public void matches_in_class_vs_class_total_is_correct6() {
        assertEquals(0, keeper.getMatchesInClassVSClassTotal(rVSs));
    }

    @Test
    public void wins_as_class_total_is_correct1() {
        assertEquals(4, keeper.getWinsAsClassTotal(DeckClass.SHAMAN));
    }

    @Test
    public void wins_as_class_total_is_correct2() {
        assertEquals(0, keeper.getWinsAsClassTotal(DeckClass.PRIEST));
    }

    @Test
    public void wins_vs_class_total_is_correct1() {
        assertEquals(2, keeper.getWinsVSClassTotal(DeckClass.MAGE));
    }

    @Test
    public void wins_vs_class_total_is_correct2() {
        assertEquals(2, keeper.getWinsVSClassTotal(DeckClass.DRUID));
    }

    @Test
    public void wins_vs_class_total_is_correct3() {
        assertEquals(0, keeper.getWinsVSClassTotal(DeckClass.ROGUE));
    }

    @Test
    public void wins_in_class_vs_class_total_is_correct1() {
        assertEquals(2, keeper.getWinsInClassVSClassTotal(sVSm));
    }

    @Test
    public void wins_in_class_vs_class_total_is_correct2() {
        assertEquals(2, keeper.getWinsInClassVSClassTotal(sVSd));
    }

    @Test
    public void wins_in_class_vs_class_total_is_correct3() {
        assertEquals(0, keeper.getWinsInClassVSClassTotal(prVSwarr));
    }

    @Test
    public void losses_as_class_total_is_correct1() {
        assertEquals(4, keeper.getLossesAsClassTotal(DeckClass.SHAMAN));
    }

    @Test
    public void losses_as_class_total_is_correct2() {
        assertEquals(1, keeper.getLossesAsClassTotal(DeckClass.PRIEST));
    }

    @Test
    public void losses_as_class_total_is_correct3() {
        assertEquals(0, keeper.getLossesAsClassTotal(DeckClass.WARLOCK));
    }

    @Test
    public void losses_vs_class_total_is_correct1() {
        assertEquals(2, keeper.getLossesVSClassTotal(DeckClass.MAGE));
    }

    @Test
    public void losses_vs_class_total_is_correct2() {
        assertEquals(2, keeper.getLossesVSClassTotal(DeckClass.PALADIN));
    }

    @Test
    public void losses_vs_class_total_is_correct3() {
        assertEquals(1, keeper.getLossesVSClassTotal(DeckClass.WARRIOR));
    }

    @Test
    public void losses_vs_class_total_is_correct4() {
        assertEquals(0, keeper.getLossesVSClassTotal(DeckClass.ROGUE));
    }

    @Test
    public void losses_in_class_vs_class_is_correct1() {
        assertEquals(2, keeper.getLossesInClassVSClassTotal(sVSm));
    }

    @Test
    public void losses_in_class_vs_class_is_correct2() {
        assertEquals(2, keeper.getLossesInClassVSClassTotal(sVSpa));
    }

    @Test
    public void losses_in_class_vs_class_is_correct3() {
        assertEquals(1, keeper.getLossesInClassVSClassTotal(prVSwarr));
    }

    @Test
    public void losses_in_class_vs_class_is_correct4() {
        assertEquals(0, keeper.getLossesInClassVSClassTotal(rVSs));
    }

    @Test
    public void loss_percentage_as_class_1st_is_correct1() {
        assertEquals(0.5, keeper.getLossPerAsClass1st(DeckClass.SHAMAN), 0.0001);
    }

    @Test
    public void loss_percentage_as_class_1st_is_correct2() {
        assertEquals(0, keeper.getLossPerAsClass1st(DeckClass.PRIEST), 0.0001);
    }

    @Test
    public void loss_percentage_as_class_2nd_is_correct1() {
        assertEquals(0.5, keeper.getLossPerAsClass2nd(DeckClass.SHAMAN), 0.0001);
    }

    @Test
    public void loss_percentage_as_class_2nd_is_correct2() {
        assertEquals(1, keeper.getLossPerAsClass2nd(DeckClass.PRIEST), 0.0001);
    }

    @Test
    public void loss_percentage_as_class_2nd_is_correct3() {
        assertEquals(0, keeper.getLossPerAsClass2nd(DeckClass.WARLOCK), 0.0001);
    }

    @Test
    public void loss_percentage_vs_class_1st_is_correct1() {
        assertEquals(1, keeper.getLossPerVSClass1st(DeckClass.PALADIN), 0.00001);
    }

    @Test
    public void loss_percentage_vs_class_1st_is_correct2() {
        assertEquals(0, keeper.getLossPerVSClass1st(DeckClass.ROGUE), 0.00001);
    }

    @Test
    public void loss_percentage_vs_class_1st_is_correct3() {
        assertEquals(0, keeper.getLossPerVSClass1st(DeckClass.WARLOCK), 0.00001);
    }

    @Test
    public void loss_percentage_vs_class_2nd_is_correct1() {
        assertEquals(1, keeper.getLossPerVSClass2nd(DeckClass.MAGE), 0.0001);
    }

    @Test
    public void loss_percentage_vs_class_2nd_is_correct2() {
        assertEquals(1, keeper.getLossPerVSClass2nd(DeckClass.WARRIOR), 0.00001);
    }

    @Test
    public void loss_percentage_vs_class_2nd_is_correct3() {
        assertEquals(0, keeper.getLossPerVSClass2nd(DeckClass.WARLOCK), 0.00001);
    }

    @Test
    public void loss_percentage_in_class_vs_class_1st_is_correct1() {
        assertEquals(1, keeper.getLossPerInClassVSClass1st(sVSpa), 0.00001);
    }

    @Test
    public void loss_percentage_in_class_vs_class_1st_is_correct2() {
        assertEquals(0, keeper.getLossPerInClassVSClass1st(sVSr), 0.00001);
    }

    @Test
    public void loss_percentage_in_class_vs_class_1st_is_correct3() {
        assertEquals(0, keeper.getLossPerInClassVSClass1st(rVSs), 0.0001);
    }

    @Test
    public void loss_percentage_in_class_vs_class_2nd_is_correct1() {
        assertEquals(1, keeper.getLossPerInClassVSClass2nd(sVSm), 0.00001);
    }

    @Test
    public void loss_percentage_in_class_vs_class_2nd_is_correct2() {
        assertEquals(1, keeper.getLossPerInClassVSClass2nd(prVSwarr), 0.00001);
    }

    @Test
    public void loss_percentage_in_class_vs_class_2nd_is_correct3() {
        assertEquals(0, keeper.getLossPerInClassVSClass2nd(sVSpa), 0.0001);
    }

    @Test
    public void win_percentage_as_class_total_is_correct1() {
        assertEquals(0.5, keeper.getWinPerAsClassTotal(DeckClass.SHAMAN), 0.0001);
    }

    @Test
    public void win_percentage_as_class_total_is_correct2() {
        assertEquals(0, keeper.getWinPerAsClassTotal(DeckClass.PRIEST), 0.0001);
    }

    @Test
    public void win_percentage_as_class_total_is_correct3() {
        assertEquals(0, keeper.getWinPerAsClassTotal(DeckClass.WARLOCK), 0.0001);
    }

    @Test
    public void win_percentage_vs_class_total_is_correct1() {
        assertEquals(0.5, keeper.getWinPerVSClassTotal(DeckClass.MAGE), 0.0001);
    }

    @Test
    public void win_percentage_vs_class_total_is_correct2() {
        assertEquals(1, keeper.getWinPerVSClassTotal(DeckClass.DRUID), 0.0001);
    }

    @Test
    public void win_percentage_vs_class_total_is_correct3() {
        assertEquals(0, keeper.getWinPerVSClassTotal(DeckClass.PALADIN), 0.00001);
    }

    @Test
    public void win_percentage_vs_class_total_is_correct4() {
        assertEquals(0, keeper.getWinPerVSClassTotal(DeckClass.ROGUE), 0.0001);
    }

    @Test
    public void win_percentage_vs_class_total_is_correct5() {
        assertEquals(0, keeper.getWinPerVSClassTotal(DeckClass.WARRIOR), 0.00001);
    }

    @Test
    public void win_percentage_vs_class_total_is_correct6() {
        assertEquals(0, keeper.getWinPerVSClassTotal(DeckClass.WARLOCK), 0.00001);
    }

    @Test
    public void win_percentage_in_class_vs_class_total_is_correct1() {
        assertEquals(0.5, keeper.getWinPerInClassVSClassTotal(sVSm), 0.0001);
    }

    @Test
    public void win_percentage_in_class_vs_class_total_is_correct2() {
        assertEquals(1, keeper.getWinPerInClassVSClassTotal(sVSd), 0.00001);
    }

    @Test
    public void win_percentage_in_class_vs_class_total_is_correct3() {
        assertEquals(0, keeper.getWinPerInClassVSClassTotal(sVSpa), 0.0001);
    }

    @Test
    public void win_percentage_in_class_vs_class_total_is_correct4() {
        assertEquals(0, keeper.getWinPerInClassVSClassTotal(sVSr), 0.0001);
    }

    @Test
    public void win_percentage_in_class_vs_class_total_is_correct5() {
        assertEquals(0, keeper.getWinPerInClassVSClassTotal(prVSwarr), 0.00001);
    }

    @Test
    public void win_percentage_in_class_vs_class_total_is_correct6() {
        assertEquals(0, keeper.getWinPerInClassVSClassTotal(rVSs), 0.00001);
    }

    @Test
    public void loss_percentage_as_class_total_is_correct1() {
        assertEquals(0.5, keeper.getLossPerAsClassTotal(DeckClass.SHAMAN), 0.0001);
    }

    @Test
    public void loss_percentage_as_class_total_is_correct2() {
        assertEquals(1, keeper.getLossPerAsClassTotal(DeckClass.PRIEST), 0.00001);
    }

    @Test
    public void loss_percentage_as_class_total_is_correct3() {
        assertEquals(0, keeper.getLossPerAsClassTotal(DeckClass.WARLOCK), 0.00001);
    }

    @Test
    public void loss_percentage_vs_class_total_is_correct1() {
        assertEquals(0.5, keeper.getLossPerVSClassTotal(DeckClass.MAGE), 0.0001);
    }

    @Test
    public void loss_percentage_vs_class_total_is_correct2() {
        assertEquals(0, keeper.getLossPerVSClassTotal(DeckClass.DRUID), 0.00001);
    }

    @Test
    public void loss_percentage_vs_class_total_is_correct3() {
        assertEquals(1, keeper.getLossPerVSClassTotal(DeckClass.PALADIN), 0.00001);
    }

    @Test
    public void loss_percentage_vs_class_total_is_correct4() {
        assertEquals(0, keeper.getLossPerVSClassTotal(DeckClass.ROGUE), 0.00001);
    }

    @Test
    public void loss_percentage_vs_class_total_is_correct5() {
        assertEquals(1, keeper.getLossPerVSClassTotal(DeckClass.WARRIOR), 0.0001);
    }

    @Test
    public void loss_percentage_vs_class_total_is_correct6() {
        assertEquals(0, keeper.getLossPerVSClassTotal(DeckClass.WARLOCK), 0.0001);
    }

    @Test
    public void loss_percentage_in_class_vs_class_total_is_correct1() {
        assertEquals(0.5, keeper.getLossPerInClassVSClassTotal(sVSm), 0.0001);
    }

    @Test
    public void loss_percentage_in_class_vs_class_total_is_correct2() {
        assertEquals(0, keeper.getLossPerInClassVSClassTotal(sVSd), 0.0001);
    }

    @Test
    public void loss_percentage_in_class_vs_class_total_is_correct3() {
        assertEquals(1, keeper.getLossPerInClassVSClassTotal(sVSpa), 0.0001);
    }

    @Test
    public void loss_percentage_in_class_vs_class_total_is_correct4() {
        assertEquals(0, keeper.getLossPerInClassVSClassTotal(sVSr), 0.0001);
    }

    @Test
    public void loss_percentage_in_class_vs_class_total_is_correct5() {
        assertEquals(1, keeper.getLossPerInClassVSClassTotal(prVSwarr), 0.0001);
    }

    @Test
    public void loss_percentage_in_class_vs_class_total_is_correct6() {
        assertEquals(0, keeper.getLossPerInClassVSClassTotal(rVSs), 0.00001);
    }

    @Test
    public void total_matches_is_correct() {
        assertEquals(11, keeper.getTotalMatches());
    }

    @Test
    public void total_wins_is_correct() {
        assertEquals(4, keeper.getTotalWins());
    }

    @Test
    public void total_losses_is_correct() {
        assertEquals(5, keeper.getTotalLosses());
    }

    @Test
    public void total_win_percent_is_correct() {
        assertEquals(0.44, keeper.getTotalWinPer(), 0.01);
    }

    @Test
    public void total_loss_percent_is_correct() {
        assertEquals(0.55, keeper.getTotalLossPer(), 0.01);
    }

    @Test
    public void total_loss_percent_is_zero_when_only_disconnects() {
        keeper.reset();
        Match match = new Match(DeckClass.WARLOCK, "", Outcome.DISCONNECT, true, 1, 1);
        Deck deck = new Deck(DeckClass.WARRIOR, 1);
        DeckHandler handler = new DeckHandler();
        handler.setDeck(deck);
        handler.addMatch(match);
        List<Deck> list = new ArrayList();
        keeper.addMatches(list);
        assertEquals(0, keeper.getTotalLossPer(), 0.00001);
    }

    @Test
    public void remove_match_removes_match_from_matches_as_class_1st() {
        keeper.removeMatchFromStatistics(match1);
        assertEquals(4, keeper.getMatchesAsClass1st(DeckClass.SHAMAN));
    }

    @Test
    public void remove_match_removes_match_from_matches_as_class_2nd() {
        keeper.removeMatchFromStatistics(match2);
        assertEquals(3, keeper.getMatchesAsClass2nd(DeckClass.SHAMAN));
    }

    @Test
    public void remove_match_removes_match_from_matches_vs_class_1st() {
        keeper.removeMatchFromStatistics(match1);
        assertEquals(1, keeper.getMatchesVSClass1st(DeckClass.MAGE));
    }

    @Test
    public void remove_match_removes_match_from_matches_vs_class_2nd() {
        keeper.removeMatchFromStatistics(match3);
        assertEquals(1, keeper.getMatchesVSClass2nd(DeckClass.DRUID));
    }

    @Test
    public void remove_match_removes_match_from_wins_as_class_1st() {
        keeper.removeMatchFromStatistics(match1);
        assertEquals(1, keeper.getWinsAsClass1st(DeckClass.SHAMAN));
    }

    @Test
    public void remove_match_removes_match_from_wins_as_class_2nd() {
        keeper.removeMatchFromStatistics(match3);
        assertEquals(1, keeper.getWinsAsClass2nd(DeckClass.SHAMAN));
    }

    @Test
    public void remove_match_removes_match_from_wins_vs_class_1st() {
        keeper.removeMatchFromStatistics(match1);
        assertEquals(1, keeper.getWinsVSClass1st(DeckClass.MAGE));
    }

    @Test
    public void remove_match_removes_match_from_wins_vs_class_2nd() {
        keeper.removeMatchFromStatistics(match3);
        assertEquals(1, keeper.getWinsVSClass2nd(DeckClass.DRUID));
    }

    @Test
    public void remove_match_removes_match_from_losses_as_class_1st() {
        keeper.removeMatchFromStatistics(match4);
        assertEquals(1, keeper.getLossesAsClass1st(DeckClass.SHAMAN));
    }

    @Test
    public void remove_match_removes_match_from_losses_as_class_2nd() {
        keeper.removeMatchFromStatistics(match2);
        assertEquals(1, keeper.getLossesAsClass2nd(DeckClass.SHAMAN));
    }

    @Test
    public void remove_match_removes_match_from_losses_vs_class_1st() {
        keeper.removeMatchFromStatistics(match4);
        assertEquals(1, keeper.getLossesVSClass1st(DeckClass.PALADIN));
    }

    @Test
    public void remove_match_removes_match_from_losses_vs_class_2nd() {
        keeper.removeMatchFromStatistics(match2);
        assertEquals(1, keeper.getLossesVSClass2nd(DeckClass.MAGE));
    }

    @Test
    public void remove_match_removes_match_from_matches_in_class_vs_class_1st() {
        keeper.removeMatchFromStatistics(match1);
        assertEquals(1, keeper.getMatchesInClassVSClass1st(sVSm));
    }

    @Test
    public void remove_match_removes_match_from_matches_in_class_vs_class_2nd() {
        keeper.removeMatchFromStatistics(match10);
        assertEquals(0, keeper.getMatchesInClassVSClass2nd(prVSwarr));
    }

    @Test
    public void remove_match_removes_match_from_wins_in_class_vs_class_1st() {
        keeper.removeMatchFromStatistics(match1);
        assertEquals(1, keeper.getWinsInClassVSClass1st(sVSm));
    }

    @Test
    public void remove_match_removes_match_from_wins_in_class_vs_class_2nd() {
        keeper.removeMatchFromStatistics(match3);
        assertEquals(1, keeper.getWinsInClassVSClass2nd(sVSd));
    }

    @Test
    public void remove_match_removes_match_from_losses_in_class_vs_class_1st() {
        keeper.removeMatchFromStatistics(match4);
        assertEquals(1, keeper.getLossesInClassVSClass1st(sVSpa));
    }

    @Test
    public void remove_match_removes_match_from_losses_in_class_vs_class_2nd() {
        keeper.removeMatchFromStatistics(match2);
        assertEquals(1, keeper.getLossesInClassVSClass2nd(sVSm));
    }

    @Test
    public void remove_match_affects_win_percentage_as_class_1st() {
        keeper.removeMatchFromStatistics(match1);
        assertEquals(0.33, keeper.getWinPerAsClass1st(DeckClass.SHAMAN), 0.01);
    }

    @Test
    public void remove_match_affects_win_percentage_as_class_2nd() {
        keeper.removeMatchFromStatistics(match3);
        assertEquals(0.33, keeper.getWinPerAsClass2nd(DeckClass.SHAMAN), 0.01);
    }

    @Test
    public void remove_match_affects_win_percentage_vs_class_total() {
        keeper.removeMatchFromStatistics(match1);
        assertEquals(0.33, keeper.getWinPerVSClassTotal(DeckClass.MAGE), 0.01);
    }

    @Test
    public void remove_match_affects_win_percentage_in_class_vs_class_total() {
        keeper.removeMatchFromStatistics(match1);
        assertEquals(0.33, keeper.getWinPerInClassVSClassTotal(sVSm), 0.01);
    }

    @Test
    public void set_losses_as_class_1st_works_correctly() {
        keeper.setLossesAsClass1st(DeckClass.PRIEST, 100);
        assertEquals(100, keeper.getLossesAsClass1st(DeckClass.PRIEST));
    }

    @Test
    public void set_losses_as_class_2nd_works_correctly() {
        keeper.setLossesAsClass2nd(DeckClass.DRUID, 200);
        assertEquals(200, keeper.getLossesAsClass2nd(DeckClass.DRUID));
    }

    @Test
    public void set_losses_in_class_vs_class_1st_works_correctly() {
        keeper.setLossesInClassVSClass1st(sVSm, 1000);
        assertEquals(1000, keeper.getLossesInClassVSClass1st(sVSm));
    }

    @Test
    public void set_losses_in_class_vs_class_2nd_works_correctly() {
        keeper.setLossesInClassVSClass2nd(sVSm, 15);
        assertEquals(15, keeper.getLossesInClassVSClass2nd(sVSm));
    }

    @Test
    public void set_losses_vs_class_1st_works_correctly() {
        keeper.setLossesVSClass1st(DeckClass.DRUID, 111);
        assertEquals(111, keeper.getLossesVSClass1st(DeckClass.DRUID));
    }

    @Test
    public void set_losses_vs_class_2nd_works_correctly() {
        keeper.setLossesVSClass2nd(DeckClass.DRUID, 1111);
        assertEquals(1111, keeper.getLossesVSClass2nd(DeckClass.DRUID));
    }

    @Test
    public void set_matches_as_class_1st_works_correctly() {
        keeper.setMatchesAsClass1st(DeckClass.DRUID, 555);
        assertEquals(555, keeper.getMatchesAsClass1st(DeckClass.DRUID));
    }

    @Test
    public void set_matches_as_class_2nd_works_correctly() {
        keeper.setMatchesAsClass2nd(DeckClass.DRUID, 5);
        assertEquals(5, keeper.getMatchesAsClass2nd(DeckClass.DRUID));
    }

    @Test
    public void set_matches_in_class_vs_class_1st_works_correctly() {
        keeper.setMatchesInClassVSClass1st(sVSm, 40);
        assertEquals(40, keeper.getMatchesInClassVSClass1st(sVSm));
    }

    @Test
    public void set_matches_in_class_vs_class_2nd_works_correctly() {
        keeper.setMatchesInClassVSClass2nd(sVSm, 444);
        assertEquals(444, keeper.getMatchesInClassVSClass2nd(sVSm));
    }

    @Test
    public void set_matches_vs_class_1st_works_correctly() {
        keeper.setMatchesVSClass1st(DeckClass.DRUID, 123);
        assertEquals(123, keeper.getMatchesVSClass1st(DeckClass.DRUID));
    }

    @Test
    public void set_matches_vs_class_2nd_works_correctly() {
        keeper.setMatchesVSClass2nd(DeckClass.DRUID, 4000);
        assertEquals(4000, keeper.getMatchesVSClass2nd(DeckClass.DRUID));
    }

    @Test
    public void set_win_per_as_class_1st_works_correctly() {
        keeper.setWinPerAsClass1st(DeckClass.DRUID, 34.22);
        assertEquals(34.22, keeper.getWinPerAsClass1st(DeckClass.DRUID), 0.0);
    }

    @Test
    public void set_win_per_as_class_2nd_works_correctly() {
        keeper.setWinPerAsClass2nd(DeckClass.DRUID, 66.66);
        assertEquals(66.66, keeper.getWinPerAsClass2nd(DeckClass.DRUID), 0.0);
    }

    @Test
    public void set_win_per_class_vs_class_1st_works_correctly() {
        keeper.setWinPerClassVSClass1st(sVSm, 500);
        assertEquals(500, keeper.getWinPerClassVSClass1st(sVSm), 0.0);
    }

    @Test
    public void set_win_per_class_vs_class_2nd_works_correctly() {
        keeper.setWinPerClassVSClass2nd(sVSm, 99.9);
        assertEquals(99.9, keeper.getWinPerClassVSClass2nd(sVSm), 0.0);
    }

    @Test
    public void set_win_per_vs_class_1st_works_correctly() {
        keeper.setWinPerVSClass1st(DeckClass.DRUID, 33.3);
        assertEquals(33.3, keeper.getWinPerVSClass1st(DeckClass.DRUID), 0.0);
    }

    @Test
    public void set_win_per_vs_class_2nd_works_correctly() {
        keeper.setWinPerVSClass2nd(DeckClass.DRUID, 55.5);
        assertEquals(55.5, keeper.getWinPerVSClass2nd(DeckClass.DRUID), 0.0);
    }

    @Test
    public void set_wins_as_class_1st_works_correctly() {
        keeper.setWinsAsClass1st(DeckClass.DRUID, 4441);
        assertEquals(4441, keeper.getWinsAsClass1st(DeckClass.DRUID));
    }

    @Test
    public void set_wins_as_class_2nd_works_correctly() {
        keeper.setWinsAsClass2nd(DeckClass.DRUID, 113);
        assertEquals(113, keeper.getWinsAsClass2nd(DeckClass.DRUID));
    }

    @Test
    public void set_wins_in_class_vs_class_1st_works_correctly() {
        keeper.setWinsInClassVSClass1st(sVSm, 33);
        assertEquals(33, keeper.getWinsInClassVSClass1st(sVSm));
    }

    @Test
    public void set_wins_in_class_vs_class_2nd_works_correctly() {
        keeper.setWinsInClassVSClass2nd(sVSm, 99);
        assertEquals(99, keeper.getWinsInClassVSClass2nd(sVSm));
    }

    @Test
    public void set_wins_vs_class_1st_works_correctly() {
        keeper.setWinsVSClass1st(DeckClass.DRUID, 1134);
        assertEquals(1134, keeper.getWinsVSClass1st(DeckClass.DRUID));
    }

    @Test
    public void set_wins_vs_class_2nd_works_correctly() {
        keeper.setWinsVSClass2nd(DeckClass.DRUID, 1234);
        assertEquals(1234, keeper.getWinsVSClass2nd(DeckClass.DRUID));
    }
}
