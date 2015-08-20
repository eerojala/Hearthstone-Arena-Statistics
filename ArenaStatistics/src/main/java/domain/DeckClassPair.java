
package domain;

import java.util.ArrayList;
import java.util.List;

public class DeckClassPair {
    private final DeckClass playerDeckClass;
    private final DeckClass opponentDeckClass;

    public DeckClassPair(DeckClass playerDeckClass, DeckClass opponentDeckClass) {
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
        if (obj == null || obj.getClass() != DeckClassPair.class) {
            return false;
        }
        
        DeckClassPair dcp = (DeckClassPair) obj;
        
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
    
    public static DeckClassPair parseDeckClassPair(String string) {
        for (DeckClassPair dcp : getDeckClassPairList()) {
            if (string.equals(dcp.toString())) {
                return dcp;
            }
        }
        return null;
    }
    
     public static List<DeckClassPair> getDeckClassPairList() {
        List<DeckClassPair> list = new ArrayList();
        for (DeckClass dc1 : DeckClass.values()) {
            for (DeckClass dc2 : DeckClass.values()) {
                list.add(new DeckClassPair(dc1, dc2));
            }
        }
        return list;
    }
}
