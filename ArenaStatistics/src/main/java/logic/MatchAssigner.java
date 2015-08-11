package logic;

import domain.Deck;
import domain.Match;
import java.util.List;
import java.util.Collections;

public class MatchAssigner {

    private int i;
    private int j;
    private DeckHandler handler;

    public void assignMatches(List<Deck> decks, List<Match> matches) {
        initialize(decks, matches);
        while (j < matches.size()) {
            connectMatchToDeck(decks, matches);
        }
    }

    private void initialize(List<Deck> decks, List<Match> matches) {
        Collections.sort(decks);
        Collections.sort(matches);
        i = 0;
        j = 0;
        handler = new DeckHandler();
    }

    private void connectMatchToDeck(List<Deck> decks, List<Match> matches) {
        Deck deck = decks.get(i);
        handler.setDeck(deck);
        Match match = matches.get(j);
        if (handler.addMatch(match)) { // if deck has 12 wins or 3 losses
            i++;
        }
        j++;
    }

}
