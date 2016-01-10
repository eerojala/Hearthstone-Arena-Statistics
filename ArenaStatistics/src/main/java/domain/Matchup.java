
package domain;

import java.util.ArrayList;
import java.util.List;

public class Matchup {
    private final DeckClass playerDeckClass;
    private final DeckClass opponentDeckClass;

    public Matchup(DeckClass playerDeckClass, DeckClass opponentDeckClass) {
        this.playerDeckClass = playerDeckClass;
        this.opponentDeckClass = opponentDeckClass;
    }

    public DeckClass getOpponentDeckClass() {
        return opponentDeckClass;
    }

    public DeckClass getPlayerDeckClass() {
        return playerDeckClass;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != Matchup.class) {
            return false;
        }
        
        Matchup dcp = (Matchup) obj;
        
        if (dcp.getOpponentDeckClass().equals(getOpponentDeckClass()) && 
                dcp.getPlayerDeckClass().equals(getPlayerDeckClass())) {
            return true;
        }
        
        return false;
    }

    @Override
    public String toString() {
        return playerDeckClass + "VS" + opponentDeckClass;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
    
    public static Matchup parseDeckClassPair(String string) {
        for (Matchup dcp : getDeckClassPairList()) {
            if (string.equals(dcp.toString())) {
                return dcp;
            }
        }
        return null;
    }
    
     public static List<Matchup> getDeckClassPairList() {
        List<Matchup> list = new ArrayList();
        for (DeckClass dc1 : DeckClass.values()) {
            for (DeckClass dc2 : DeckClass.values()) {
                list.add(new Matchup(dc1, dc2));
            }
        }
        return list;
    }
}
