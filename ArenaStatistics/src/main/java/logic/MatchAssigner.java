package logic;

import domain.Deck;
import domain.Match;
import java.util.List;

public class MatchAssigner {

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
