package logic;

import domain.Deck;
import domain.DeckClass;
import domain.DeckClassPair;
import domain.Match;
import domain.Outcome;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import util.TestHelper;

public class ClassVSClassStatisticsKeeperTest {

    ClassVSClassStatisticsKeeper keeper;
    boolean bool;
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

    public ClassVSClassStatisticsKeeperTest() {
        keeper = new ClassVSClassStatisticsKeeper();
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
        addMatches(list);
        sVSm = new DeckClassPair(DeckClass.SHAMAN, DeckClass.MAGE);
        sVSd = new DeckClassPair(DeckClass.SHAMAN, DeckClass.DRUID);
        sVSpa = new DeckClassPair(DeckClass.SHAMAN, DeckClass.PALADIN);
        prVSwarr = new DeckClassPair(DeckClass.PRIEST, DeckClass.WARRIOR);
        sVSr = new DeckClassPair(DeckClass.SHAMAN, DeckClass.ROGUE);
        rVSs = new DeckClassPair(DeckClass.ROGUE, DeckClass.SHAMAN);
    }

    private void addMatches(List<Deck> list) {
        for (Deck deck : list) {
            for (Match match : deck.getMatches()) {
                keeper.addMatch(match);
            }
        }
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

    @After
    public void tearDown() {
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
        bool = TestHelper.zeroesInDcpIntMap(keeper.getStatistics().getWinsInClassVSClass1st(), sVSm);
        assertTrue(bool);
    }

    @Test
    public void wins_in_class_vs_class_going_2nd_is_correct1() {
        assertEquals(2, keeper.getWinsInClassVSClass2nd(sVSd));
    }

    @Test
    public void wins_in_class_vs_class_going_2nd_is_correct2() {
        bool = TestHelper.zeroesInDcpIntMap(keeper.getStatistics().getWinsInClassVSClass2nd(), sVSd);
        assertTrue(bool);
    }

    @Test
    public void losses_in_class_vs_class_going_1st_is_correct1() {
        assertEquals(2, keeper.getLossesInClassVSClass1st(sVSpa));
    }

    @Test
    public void losses_in_class_vs_class_going_1st_is_correct2() {
        bool = TestHelper.zeroesInDcpIntMap(keeper.getStatistics().getLossesInClassVSClass1st(), sVSpa);
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
        bool = TestHelper.zeroesInDcpIntMap(keeper.getStatistics().getLossesInClassVSClass2nd(),
                sVSm, prVSwarr);
        assertTrue(bool);
    }

    @Test
    public void win_percentage_class_vs_class_going_1st_is_correct1() {
        assertEquals(1, keeper.getWinPerClassVSClass1st(sVSm), 0.0001);
    }

    @Test
    public void win_percentage_class_vs_class_going_1st_is_correct2() {
        bool = TestHelper.zeroesInDcpDoubleMap(keeper.getStatistics().getWinPerClassVSClass1st(), sVSm);
        assertTrue(bool);
    }

    @Test
    public void win_percentage_class_vs_class_going_second_is_correct1() {
        assertEquals(1, keeper.getWinPerClassVSClass2nd(sVSd), 0.00001);
    }

    @Test
    public void win_percentage_class_vs_class_going_second_is_correct2() {
        bool = TestHelper.zeroesInDcpDoubleMap(keeper.getStatistics().getWinPerClassVSClass2nd(), sVSd);
        assertTrue(bool);
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
    public void remove_match_removes_match_from_matches_in_class_vs_class_1st() {
        keeper.removeMatch(match1);
        assertEquals(1, keeper.getMatchesInClassVSClass1st(sVSm));
    }

    @Test
    public void remove_match_removes_match_from_matches_in_class_vs_class_2nd() {
        keeper.removeMatch(match10);
        assertEquals(0, keeper.getMatchesInClassVSClass2nd(prVSwarr));
    }

    @Test
    public void remove_match_removes_match_from_wins_in_class_vs_class_1st() {
        keeper.removeMatch(match1);
        assertEquals(1, keeper.getWinsInClassVSClass1st(sVSm));
    }

    @Test
    public void remove_match_removes_match_from_wins_in_class_vs_class_2nd() {
        keeper.removeMatch(match3);
        assertEquals(1, keeper.getWinsInClassVSClass2nd(sVSd));
    }

    @Test
    public void remove_match_removes_match_from_losses_in_class_vs_class_1st() {
        keeper.removeMatch(match4);
        assertEquals(1, keeper.getLossesInClassVSClass1st(sVSpa));
    }

    @Test
    public void remove_match_removes_match_from_losses_in_class_vs_class_2nd() {
        keeper.removeMatch(match2);
        assertEquals(1, keeper.getLossesInClassVSClass2nd(sVSm));
    }

    @Test
    public void remove_match_affects_win_percentage_in_class_vs_class_total() {
        keeper.removeMatch(match1);
        assertEquals(0.33, keeper.getWinPerInClassVSClassTotal(sVSm), 0.01);
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
    public void updateWinPercentage1st_works_correctly() {
        keeper.setMatchesInClassVSClass1st(sVSm, 7);
        keeper.setWinsInClassVSClass1st(sVSm, 4);
        keeper.setLossesInClassVSClass1st(sVSm, 1);
        keeper.updateWinPercentage1st(sVSm);
        assertEquals(0.8, keeper.getWinPerClassVSClass1st(sVSm), 0);
    }
    
    @Test
    public void updateWinPercentage2nd_works_correctly() {
        keeper.setMatchesInClassVSClass2nd(sVSm, 10);
        keeper.setWinsInClassVSClass2nd(sVSm, 8);
        keeper.setLossesInClassVSClass2nd(sVSm, 2);
        keeper.updateWinPercentage2nd(sVSm);
        assertEquals(0.80, keeper.getWinPerClassVSClass2nd(sVSm), 0);
    }
    
    
}
