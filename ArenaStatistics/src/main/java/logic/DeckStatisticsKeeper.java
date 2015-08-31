package logic;

import domain.Deck;
import java.util.List;

public abstract class DeckStatisticsKeeper {

    public void addDecks(List<Deck> decks) {
        for (Deck deck : decks) {
            addDeck(deck);
        }
    }
    
    public abstract void addDeck(Deck deck);
    public abstract void removeDeck(Deck deck);
    public abstract int getTotalDeckAmount();
    public abstract int getDecksByWins(int wins);
    public abstract void reset();
}
