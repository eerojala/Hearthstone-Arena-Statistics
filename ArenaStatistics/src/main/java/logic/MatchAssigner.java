package logic;

import domain.Deck;
import domain.Match;
import java.util.List;
import java.util.Collections;

public class MatchAssigner {

    private static int i;
    private static int j;
    private static DeckHandler handler;

    public static void assignMatches(List<Deck> decks, List<Match> matches) {
        if (!(decks.isEmpty() || matches.isEmpty())) {
            initialize(decks, matches);
            while (j < matches.size()) {
                connectMatchToDeck(decks, matches);
            }
        }
    }

    private static void initialize(List<Deck> decks, List<Match> matches) {
        Collections.sort(decks);
        Collections.sort(matches);
        i = 0;
        j = 0;
        handler = new DeckHandler();
    }

    private static void connectMatchToDeck(List<Deck> decks, List<Match> matches) {
        Deck deck = decks.get(i);
        handler.setDeck(deck);
        Match match = matches.get(j);
        if (handler.addMatch(match)) { // if deck has 12 wins or 3 losses
            i++;
        }
        j++;
    }

}
