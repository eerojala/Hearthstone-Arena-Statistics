package logic;

import domain.Deck;
import domain.Match;
import java.util.List;

/**
 * Class which assigns a List of Matches to a Deck.
 */
public class MatchAssigner {

    /**
     * Assigns a list of Matches to a Deck.
     * 
     * @param deck Deck which the matches are added to.
     * @param matches Matches which are added to the Deck.
     */
    public static void assignMatchesToDeck(Deck deck, List<Match> matches) {       
        DeckHandler handler = new DeckHandler();
        handler.setDeck(deck);
        
        if (deck != null && matches != null && !matches.isEmpty()) {
            for (Match match : matches) {
                handler.addMatch(match);
            }
        }
    }
}
