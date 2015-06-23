package domain;

public class Match {

    private final DeckClass playerClass;
    private final DeckClass opponentClass;
    private final String opponentName;
    private final Outcome outcome;
    private final int deckNumber;
    private final int matchNumber;

    public Match(DeckClass playerClass, DeckClass opponentClass, String opponentName,
            Outcome outcome, int deckNumber, int matchNumber) {
        this.playerClass = playerClass;
        this.opponentClass = opponentClass;
        this.opponentName = opponentName;
        this.outcome = outcome;
        this.deckNumber = deckNumber;
        this.matchNumber = matchNumber;
    }

    public int getDeckNumber() {
        return deckNumber;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public DeckClass getOpponentClass() {
        return opponentClass;
    }

    public String getOpponentName() {
        return opponentName;
    }

    public DeckClass getPlayerClass() {
        return playerClass;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Match match = (Match) obj;

        if (this.deckNumber == match.getDeckNumber() && 
                this.matchNumber == match.getMatchNumber()) {
            return true;
        }
        return false;
    }

}
