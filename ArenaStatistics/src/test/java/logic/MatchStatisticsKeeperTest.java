package logic;

import domain.Deck;
import domain.DeckClass;
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

public class MatchStatisticsKeeperTest {

    MatchStatisticsKeeper keeper;
    boolean bool;
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
        addMatches(list);
    }
    
    private void addMatches(List<Deck> list) {
        for (Deck deck : list) {
            for (Match match : deck.getMatches()) {
                keeper.addMatch(match);
            }
        }
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
        bool = TestHelper.zeroesInDcIntMap(keeper.getStatistics().getMatchesAsClass1st(), DeckClass.SHAMAN, DeckClass.PRIEST);
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
        bool = TestHelper.zeroesInDcIntMap(keeper.getStatistics().getMatchesAsClass2nd(), DeckClass.PRIEST, DeckClass.SHAMAN);
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
        bool = TestHelper.zeroesInDcIntMap(keeper.getStatistics().getMatchesVSClass1st(), DeckClass.MAGE,
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
        bool = TestHelper.zeroesInDcIntMap(keeper.getStatistics().getMatchesVSClass2nd(), DeckClass.MAGE,
                DeckClass.DRUID, DeckClass.WARRIOR);
        assertTrue(bool);
    }

    @Test
    public void wins_as_class_going_1st_is_correct1() {
        assertEquals(2, keeper.getWinsAsClass1st(DeckClass.SHAMAN));
    }

    @Test
    public void wins_as_class_going_1st_is_correct2() {
        bool = TestHelper.zeroesInDcIntMap(keeper.getStatistics().getWinsAsClass1st(), DeckClass.SHAMAN);
        assertTrue(bool);
    }

    @Test
    public void wins_as_class_going_2nd_is_correct1() {
        assertEquals(2, keeper.getWinsAsClass2nd(DeckClass.SHAMAN));
    }

    @Test
    public void wins_as_class_going_2nd_is_correct2() {
        bool = TestHelper.zeroesInDcIntMap(keeper.getStatistics().getWinsAsClass2nd(), DeckClass.SHAMAN);
        assertTrue(bool);
    }

    @Test
    public void losses_as_class_going_1st_is_correct1() {
        assertEquals(2, keeper.getLossesAsClass1st(DeckClass.SHAMAN));
    }

    @Test
    public void losses_as_class_going_1st_is_correct2() {
        bool = TestHelper.zeroesInDcIntMap(keeper.getStatistics().getLossesAsClass1st(), DeckClass.SHAMAN);
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
        bool = TestHelper.zeroesInDcIntMap(keeper.getStatistics().getLossesAsClass2nd(), DeckClass.SHAMAN, DeckClass.PRIEST);
        assertTrue(bool);
    }

    @Test
    public void wins_vs_class_going_1st_is_correct1() {
        assertEquals(2, keeper.getWinsVSClass1st(DeckClass.MAGE));
    }

    @Test
    public void wins_vs_class_going_1st_is_correct2() {
        bool = TestHelper.zeroesInDcIntMap(keeper.getStatistics().getWinsVSClass1st(), DeckClass.MAGE);
        assertTrue(bool);
    }

    @Test
    public void wins_vs_class_going_2nd_is_correct1() {
        assertEquals(2, keeper.getWinsVSClass2nd(DeckClass.DRUID));
    }

    @Test
    public void wins_vs_class_going_2nd_is_correct2() {
        bool = TestHelper.zeroesInDcIntMap(keeper.getStatistics().getWinsVSClass2nd(), DeckClass.DRUID);
        assertTrue(bool);
    }

    @Test
    public void losses_vs_class_going_1st_is_correct1() {
        assertEquals(2, keeper.getLossesVSClass1st(DeckClass.PALADIN));
    }

    @Test
    public void losses_vs_class_going_1st_is_correct2() {
        bool = TestHelper.zeroesInDcIntMap(keeper.getStatistics().getLossesVSClass1st(), DeckClass.PALADIN);
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
        bool = TestHelper.zeroesInDcIntMap(keeper.getStatistics().getLossesVSClass2nd(), DeckClass.MAGE, DeckClass.WARRIOR);
        assertTrue(bool);
    }

    @Test
    public void win_percentage_as_class_going_1st_is_correct1() {
        assertEquals(0.5, keeper.getWinPerAsClass1st(DeckClass.SHAMAN), 0.05);
    }

    @Test
    public void win_percentage_as_class_going_1st_is_correct2() {
        bool = TestHelper.zeroesInDcDoubleMap(keeper.getStatistics().getWinPerAsClass1st(), DeckClass.SHAMAN);
        assertTrue(bool);
    }

    @Test
    public void win_percentage_as_class_going_2nd_is_correct1() {
        assertEquals(0.5, keeper.getWinPerAsClass2nd(DeckClass.SHAMAN), 0.05);
    }

    @Test
    public void win_percentage_as_class_going_2nd_is_correct2() {
        bool = TestHelper.zeroesInDcDoubleMap(keeper.getStatistics().getWinPerAsClass2nd(), DeckClass.SHAMAN);
        assertTrue(bool);
    }

    @Test
    public void win_percentage_vs_class_going_1st_is_correct1() {
        assertEquals(1, keeper.getWinPerVSClass1st(DeckClass.MAGE), 0.00001);
    }

    @Test
    public void win_percentage_vs_class_going_1st_is_correct2() {
        bool = TestHelper.zeroesInDcDoubleMap(keeper.getStatistics().getWinPerVSClass1st(), DeckClass.MAGE);
        assertTrue(bool);
    }

    @Test
    public void win_percentage_vs_class_going_2nd_is_correct1() {
        assertEquals(1, keeper.getWinPerVSClass2nd(DeckClass.DRUID), 0.0001);
    }

    @Test
    public void win_percentage_vs_class_going_2nd_is_correct2() {
        bool = TestHelper.zeroesInDcDoubleMap(keeper.getStatistics().getWinPerVSClass2nd(), DeckClass.DRUID);
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
    public void remove_match_removes_match_from_matches_as_class_1st() {
        keeper.removeMatch(match1);
        assertEquals(4, keeper.getMatchesAsClass1st(DeckClass.SHAMAN));
    }

    @Test
    public void remove_match_removes_match_from_matches_as_class_2nd() {
        keeper.removeMatch(match2);
        assertEquals(3, keeper.getMatchesAsClass2nd(DeckClass.SHAMAN));
    }

    @Test
    public void remove_match_removes_match_from_matches_vs_class_1st() {
        keeper.removeMatch(match1);
        assertEquals(1, keeper.getMatchesVSClass1st(DeckClass.MAGE));
    }

    @Test
    public void remove_match_removes_match_from_matches_vs_class_2nd() {
        keeper.removeMatch(match3);
        assertEquals(1, keeper.getMatchesVSClass2nd(DeckClass.DRUID));
    }

    @Test
    public void remove_match_removes_match_from_wins_as_class_1st() {
        keeper.removeMatch(match1);
        assertEquals(1, keeper.getWinsAsClass1st(DeckClass.SHAMAN));
    }

    @Test
    public void remove_match_removes_match_from_wins_as_class_2nd() {
        keeper.removeMatch(match3);
        assertEquals(1, keeper.getWinsAsClass2nd(DeckClass.SHAMAN));
    }

    @Test
    public void remove_match_removes_match_from_wins_vs_class_1st() {
        keeper.removeMatch(match1);
        assertEquals(1, keeper.getWinsVSClass1st(DeckClass.MAGE));
    }

    @Test
    public void remove_match_removes_match_from_wins_vs_class_2nd() {
        keeper.removeMatch(match3);
        assertEquals(1, keeper.getWinsVSClass2nd(DeckClass.DRUID));
    }

    @Test
    public void remove_match_removes_match_from_losses_as_class_1st() {
        keeper.removeMatch(match4);
        assertEquals(1, keeper.getLossesAsClass1st(DeckClass.SHAMAN));
    }

    @Test
    public void remove_match_removes_match_from_losses_as_class_2nd() {
        keeper.removeMatch(match2);
        assertEquals(1, keeper.getLossesAsClass2nd(DeckClass.SHAMAN));
    }

    @Test
    public void remove_match_removes_match_from_losses_vs_class_1st() {
        keeper.removeMatch(match4);
        assertEquals(1, keeper.getLossesVSClass1st(DeckClass.PALADIN));
    }

    @Test
    public void remove_match_removes_match_from_losses_vs_class_2nd() {
        keeper.removeMatch(match2);
        assertEquals(1, keeper.getLossesVSClass2nd(DeckClass.MAGE));
    }

    @Test
    public void remove_match_affects_win_percentage_as_class_1st() {
        keeper.removeMatch(match1);
        assertEquals(0.33, keeper.getWinPerAsClass1st(DeckClass.SHAMAN), 0.01);
    }

    @Test
    public void remove_match_affects_win_percentage_as_class_2nd() {
        keeper.removeMatch(match3);
        assertEquals(0.33, keeper.getWinPerAsClass2nd(DeckClass.SHAMAN), 0.01);
    }

    @Test
    public void remove_match_affects_win_percentage_vs_class_total() {
        keeper.removeMatch(match1);
        assertEquals(0.33, keeper.getWinPerVSClassTotal(DeckClass.MAGE), 0.01);
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
    public void set_wins_vs_class_1st_works_correctly() {
        keeper.setWinsVSClass1st(DeckClass.DRUID, 1134);
        assertEquals(1134, keeper.getWinsVSClass1st(DeckClass.DRUID));
    }

    @Test
    public void set_wins_vs_class_2nd_works_correctly() {
        keeper.setWinsVSClass2nd(DeckClass.DRUID, 1234);
        assertEquals(1234, keeper.getWinsVSClass2nd(DeckClass.DRUID));
    }
    
    @Test
    public void updateWinPercentageIn1stMatchMaps_works_correctly1() {
        keeper.setMatchesAsClass1st(DeckClass.DRUID, 5);
        keeper.setWinsAsClass1st(DeckClass.DRUID, 3);
        keeper.setLossesAsClass1st(DeckClass.DRUID, 1);
        keeper.updateWinPercentageIn1stMatchMaps(DeckClass.DRUID, DeckClass.WARLOCK);
        assertEquals(0.75, keeper.getWinPerAsClass1st(DeckClass.DRUID), 0);
    }
    
    @Test
    public void updateWinPercentageIn1stMatchMaps_works_correctly2() {
        keeper.setMatchesVSClass1st(DeckClass.DRUID, 8);
        keeper.setWinsVSClass1st(DeckClass.DRUID, 2);
        keeper.setLossesVSClass1st(DeckClass.DRUID, 6);
        keeper.updateWinPercentageIn1stMatchMaps(DeckClass.WARLOCK, DeckClass.DRUID);
        assertEquals(0.25, keeper.getWinPerVSClass1st(DeckClass.DRUID), 0);
    }
    
    @Test
    public void updateWinPercentageIn2ndMatchMaps_works_correctly1() {
        keeper.setMatchesAsClass2nd(DeckClass.DRUID, 100);
        keeper.setWinsAsClass2nd(DeckClass.DRUID, 99);
        keeper.setLossesAsClass2nd(DeckClass.DRUID, 1);
        keeper.updateWinPercentageIn2ndMatchMaps(DeckClass.DRUID, DeckClass.WARLOCK);
        assertEquals(0.99, keeper.getWinPerAsClass2nd(DeckClass.DRUID), 0);
    }
    
    @Test
    public void updateWinPercentageIn2ndMatchMaps_works_correctly2() {
        keeper.setMatchesVSClass2nd(DeckClass.DRUID, 12);
        keeper.setWinsVSClass2nd(DeckClass.DRUID, 6);
        keeper.setLossesVSClass2nd(DeckClass.DRUID, 4);
        keeper.updateWinPercentageIn2ndMatchMaps(DeckClass.WARLOCK, DeckClass.DRUID);
        assertEquals(0.6, keeper.getWinPerVSClass2nd(DeckClass.DRUID), 0);
    }
}
