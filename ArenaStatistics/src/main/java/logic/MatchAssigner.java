
package logic;

import domain.Deck;
import domain.Match;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class MatchAssigner {
    private int prevDeckNumber;
    private int i;
    private int j;
    private DeckHandler handler;
    
    public void assignMatches(List<Deck> decks, List<Match> matches) {
        initialize(decks, matches);        
        while (true) {
            Deck deck = decks.get(i);
            if (matches.get(j).getDeckNumber() > prevDeckNumber) {
                
            }
        }
    }
    
    private void initialize(List<Deck> decks, List<Match> matches) {
        Collections.sort(decks);
        Collections.sort(matches);
        i = 0;
        j = 0;
        prevDeckNumber = 1;
        handler = new DeckHandler();
    }
    
    private void correctMatchIndex(List<Match> matches) {
        if (matches.get(j).getDeckNumber() != prevDeckNumber) {
            
        }
    }
}
