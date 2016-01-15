
package logic;

import domain.Match;

/**
 * Abstract Class which defines methods for statistics keepers which handle match related statistics.
 */
public abstract class MatchRelatedStatisticsKeeper {
    
    /**
     * Adds info about a match to the statistics.
     * 
     * @param match Match
     */
    public void addMatch(Match match) {
        if (match.wentFirst()) {
            addMatchThatWent1st(match);
        } else {
            addMatchThatWent2nd(match);
        }
    }
    
    /**
     * Removes info about a specific match from the statistics.
     * 
     * @param match Match
     */
    public void removeMatch(Match match) {
        if (match.wentFirst()) {
            removeMatchThatWent1st(match);
        } else {
            removeMatchThatWent2nd(match);
        }
    }
    
    /**
     * Adds info to the statistics about a match where the player went 1st.
     * 
     * @param match Match
     */
    protected abstract void addMatchThatWent1st(Match match);

    /**
     * Adds info to the statistics about a match where the player went 2nd.
     * 
     * @param match Match
     */
    protected abstract void addMatchThatWent2nd(Match match);

    /**
     * Removes info about a specific match where the player went 1st.
     * 
     * @param match Match
     */
    protected abstract void removeMatchThatWent1st(Match match);

    /**
     * Removes info about a specific match where the player went 2nd.
     * 
     * @param match Match
     */
    protected abstract void removeMatchThatWent2nd(Match match);
}
