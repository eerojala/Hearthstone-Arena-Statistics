package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a matchup of 2 classes.
 */
public class Matchup {

    private final DeckClass playerDeckClass;
    private final DeckClass opponentDeckClass;

    /**
     * Creates a new Matchup object
     *
     * @param playerDeckClass The class which the player is using.
     * @param opponentDeckClass The class which the opponent is using.
     */
    public Matchup(DeckClass playerDeckClass, DeckClass opponentDeckClass) {
        this.playerDeckClass = playerDeckClass;
        this.opponentDeckClass = opponentDeckClass;
    }

    /**
     * Returns the class used by the opponent.
     *
     * @return DeckClass of the opponent.
     */
    public DeckClass getOpponentDeckClass() {
        return opponentDeckClass;
    }

    /**
     * Returns the class used by the player.
     *
     * @return DeckClass of the player.
     */
    public DeckClass getPlayerDeckClass() {
        return playerDeckClass;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != Matchup.class) {
            return false;
        }

        Matchup dcp = (Matchup) obj;

        if (dcp.getOpponentDeckClass().equals(getOpponentDeckClass())
                && dcp.getPlayerDeckClass().equals(getPlayerDeckClass())) {
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

    /**
     * Parses a Matchup from a given String.
     *
     * @param string Text where the MatchUp is parsed from.
     * @return Matchup parsed from the String, null if the String does not match
     * a String representation of any Matchup.
     */
    public static Matchup parseMatchup(String string) {
        for (Matchup matchup : getMatchupList()) {
            if (string.equals(matchup.toString())) {
                return matchup;
            }
        }
        return null;
    }

    /**
     * Returns a list containing all the 81 possible matchups.
     *
     * @return List of all the 81 possible Matchups.
     */
    public static List<Matchup> getMatchupList() {
        List<Matchup> list = new ArrayList();
        for (DeckClass dc1 : DeckClass.values()) {
            for (DeckClass dc2 : DeckClass.values()) {
                list.add(new Matchup(dc1, dc2));
            }
        }
        return list;
    }
}
