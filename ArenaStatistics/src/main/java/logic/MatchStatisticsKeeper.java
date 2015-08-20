
package logic;

import domain.Match;


public abstract class MatchStatisticsKeeper {
    
    public void addMatch(Match match) {
        if (match.wentFirst()) {
            addMatchThatWent1st(match);
        } else {
            addMatchThatWent2nd(match);
        }
    }
    
    public void removeMatch(Match match) {
        if (match.wentFirst()) {
            removeMatchThatWent1st(match);
        } else {
            removeMatchThatWent2nd(match);
        }
    }
    
    protected abstract void addMatchThatWent1st(Match match);
    protected abstract void addMatchThatWent2nd(Match match);
    protected abstract void removeMatchThatWent1st(Match match);
    protected abstract void removeMatchThatWent2nd(Match match);
}
