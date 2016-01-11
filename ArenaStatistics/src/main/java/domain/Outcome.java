package domain;

/**
 * Enum representing the different outcomes a match in Hearthstone might have.
 */
public enum Outcome {

    /**
     * Enum representing the player winning the match. a Win occurs if the
     * opponents life points drop below 1 or if the opponent leaves the match
     * either due to a disconnect or by his own volition.
     */
    WIN("Win"),
    /**
     * Enum representing the player losing the match. a Loss occurs if the
     * players life points drop below 1 or if the player leaves the match either
     * due to a disconnect or by his own volition.
     *
     * NOTE: If the user does not want losses due to disconnect affect the match
     * win ratio, the user should choose to use the DISCONNECT Enum.
     */
    LOSS("Loss"),
    /**
     * Enum representing the match ending in a tie. a Tie occurs if both
     * player's life points drop below 1 on the same turn, the match reaches
     * round 50, or both players disconnect due to server issues.
     *
     * NOTE: If the player disconnects and gains a loss in their arena score,
     * the user should either use DISCONNECT or LOSS, depending if they want
     * their match win ratio unaffected or not.
     */
    TIE("Tie"),
    /**
     * Enum representing the match ending in a loss due to a disconnect. This
     * program treats this mostly the same as the LOSS Enum, but DISCONNECT does
     * not affect match win ratios.
     */
    DISCONNECT("Disconnect");

    private final String name;

    private Outcome(String name) {
        this.name = name;
    }

    /**
     * Returns the String representation of the Outcome.
     *
     * @return String representation of the Outcome.
     */
    public String getName() {
        return name;
    }

    /**
     * Parses an Outcome out of the given String
     *
     * @param text String from which the Outcome is parsed from.
     * @return The parsed Outcome, null if the String does not match any of the
     * Outcome's String representations.
     */
    public static Outcome parseOutcome(String text) {
        if (text.equals(Outcome.WIN.getName())) {
            return Outcome.WIN;
        } else if (text.equals(Outcome.LOSS.getName())) {
            return Outcome.LOSS;
        } else if (text.equals(Outcome.TIE.getName())) {
            return Outcome.TIE;
        } else if (text.equals(Outcome.DISCONNECT.getName())) {
            return Outcome.DISCONNECT;
        }
        return null;
    }
}
