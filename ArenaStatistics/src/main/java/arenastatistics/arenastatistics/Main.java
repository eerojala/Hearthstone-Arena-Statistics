package arenastatistics.arenastatistics;

import Xml.*;
import domain.*;
import java.util.*;
import logic.*;
import org.jdom.*;
import util.DeckClassList;

public class Main {

    public static void main(String[] args) {
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
        keeper.removeMatchFromStatistics(match1);
        keeper.getWinPerInClassVSClassTotal(sVSm);
    }

}
