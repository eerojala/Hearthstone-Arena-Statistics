package logic;

import domain.Deck;
import domain.Match;
import java.util.List;
import java.util.Collections;

public class MatchAssigner {

    private static DeckHandler handler;

    public static void assignMatchesToDeck(Deck deck, List<Match> matches) {
        if (deck != null && !matches.isEmpty()) {
            for (Match match : matches) {
                handler.addMatch(match);
            }
        }
    }
}
