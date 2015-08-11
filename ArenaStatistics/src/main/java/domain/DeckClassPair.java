
package domain;

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
        return playerDeckClass + " VS " + opponentDeckClass;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }
    
}
