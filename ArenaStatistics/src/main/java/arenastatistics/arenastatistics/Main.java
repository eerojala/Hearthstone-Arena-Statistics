package arenastatistics.arenastatistics;

import Xml.*;
import domain.*;
import java.util.*;
import logic.*;
import org.jdom.*;
import util.TestForLoop;

public class Main {

    public static void main(String[] args) {
        DeckStatisticsKeeper keeper;
        Deck deck1;
        Deck deck2;
        Deck deck3;
        Deck deck4;
        Deck deck5;
        deck1 = new Deck(DeckClass.DRUID, 1);
        deck1.setDust(200);
        deck1.setGold(200);
        deck1.setWins(12);
        deck1.setExtraPacks(1);
        deck2 = new Deck(DeckClass.MAGE, 2);
        deck2.setDust(120);
        deck2.setGold(240);
        deck2.setWins(12);
        deck3 = new Deck(DeckClass.DRUID, 3);
        deck3.setDust(40);
        deck3.setGold(50);
        deck3.setWins(4);
        deck4 = new Deck(DeckClass.SHAMAN, 4);
        deck4.setDust(20);
        deck4.setGold(30);
        deck4.setWins(4);
        deck5 = new Deck(DeckClass.MAGE, 5);
        deck5.setDust(50);
        deck5.setGold(100);
        deck5.setWins(7);
        List<Deck> dlist = new ArrayList();
        dlist.add(deck1);
        dlist.add(deck2);
        dlist.add(deck3);
        dlist.add(deck4);
        dlist.add(deck5);
        List<Card> clist = new ArrayList();
        clist.add(Card.RARE);
        deck3.setCards(clist);
        clist = new ArrayList();
        clist.add(Card.RARE);
        clist.add(Card.COMMON_GOLD);
        deck4.setCards(clist);
        keeper = new DeckStatisticsKeeper();
        keeper.addDecks(dlist);
        keeper.removeDeck(deck3);
    }

}
