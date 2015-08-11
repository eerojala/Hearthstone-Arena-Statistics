package logic;

import domain.Deck;
import domain.DeckArchive;
import domain.DeckClass;
import java.util.ArrayList;
import java.util.List;

public class DeckArchiver {
    private final DeckArchive archive;

    public DeckArchiver(List<Deck> decks) {
        archive = new DeckArchive();
        addDecksToArchive(decks);
    }

    private void addDecksToArchive(List<Deck> decks) {
        for (Deck deck : decks) {
            addDeckToArchive(deck);
        }
    }
    
    public void addDeckToArchive(Deck deck) {
        archive.getDecksByNumber().put(deck.getDeckNumber(), deck);
        addDeckToDecksByClass(deck);
        addDeckToDecksByWinCount(deck);
    }
    
    private void addDeckToDecksByClass(Deck deck) {
        List<Deck> list;
        if (archive.getDecksByClass().containsKey(deck.getDeckClass())) {
            list = archive.getDecksByClass().get(deck.getDeckClass());
        } else {
            list = new ArrayList();
        }
        list.add(deck);
        archive.getDecksByClass().put(deck.getDeckClass(), list);
    }

    private void addDeckToDecksByWinCount(Deck deck) {
        List<Deck> list;
        if (archive.getDecksByWinCount().containsKey(deck.getWins())) {
            list = archive.getDecksByWinCount().get(deck.getWins());
        } else {
            list = new ArrayList();
        }
        list.add(deck);
        archive.getDecksByWinCount().put(deck.getWins(), list);
    }

    public List<Deck> getDecksByWinCount(int wins) {
        return archive.getDecksByWinCount().get(wins);
    }

    public Deck getDeckByNumber(int deckNumber) {
        return archive.getDecksByNumber().get(deckNumber);
    }

    public List<Deck> getDecksByClass(DeckClass deckClass) {
        return archive.getDecksByClass().get(deckClass);
    }

}
