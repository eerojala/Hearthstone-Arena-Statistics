
package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeckArchive {
    private final Map<Integer, Deck> decksByNumber;
    private final Map<DeckClass, List<Deck>> decksByClass;
    private final Map<Integer, List<Deck>> decksByWinCount;

    public DeckArchive() {
        decksByClass = new HashMap();
        decksByNumber = new HashMap();
        decksByWinCount = new HashMap();
    }

    public Map<DeckClass, List<Deck>> getDecksByClass() {
        return decksByClass;
    }

    public Map<Integer, Deck> getDecksByNumber() {
        return decksByNumber;
    }

    public Map<Integer, List<Deck>> getDecksByWinCount() {
        return decksByWinCount;
    }
  
}
