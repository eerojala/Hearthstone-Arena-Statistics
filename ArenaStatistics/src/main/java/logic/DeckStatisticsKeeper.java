package logic;

import domain.Deck;
import java.util.List;

/**
 * Abstract class which defines methods for statistics keepers which handle deck related statistics.
 */
public abstract class DeckStatisticsKeeper {

    /**
     * Adds info about all of the Decks from the List to the statistics.
     * 
     * @param decks List of Decks.
     */
    public void addDecks(List<Deck> decks) {
        for (Deck deck : decks) {
            addDeck(deck);
        }
    }
    
    /**
     * Adds info about a single deck to the statistics.
     * 
     * @param deck Deck
     */
    public abstract void addDeck(Deck deck);

    /**
     * Removes info about a specific deck from the statistics.
     * 
     * @param deck Deck
     */
    public abstract void removeDeck(Deck deck);

    /**
     * Returns the total amount of decks stored in the statistics.
     * 
     * @return Total amount of decks.
     */
    public abstract int getTotalDeckAmount();

    /**
     * Returns the total amount of decks with specific win amounts stored in the statistics.
     * 
     * @param wins Amount of wins.
     * @return Total amount of decks with specific wins.
     */
    public abstract int getDecksByWins(int wins);

    /**
     * Resets the statistics, inputs zeroes as values.
     */
    public abstract void reset();
}
