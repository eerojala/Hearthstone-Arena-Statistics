package domain;

/**
 * Enum representing cards which may be included in the arena rewards.
 */
public enum Card {

    /**
     * Enum representing the regular common rarity card.
     */
    COMMON("Common", false),
    /**
     * Enum representing the regular rare rarity card.
     */
    RARE("Rare", false),
    /**
     * Enum representing the regular epic rarity card.
     */
    EPIC("Epic", false),
    /**
     * Enum representing the regular legendary rarity card.
     */
    LEGENDARY("Legendary", false),
    /**
     * Enum representing the golden common rarirty card.
     */
    COMMON_GOLD("Golden Common", true),
    /**
     * Enum representing the golden rare rarity card.
     */
    RARE_GOLD("Golden Rare", true),
    /**
     * Enum representing the golden epic rarity card.
     */
    EPIC_GOLD("Golden Epic", true),
    /**
     * Enum representing the golden legendary rarity card.
     */
    LEGENDARY_GOLD("Golden Legendary", true);

    private final String type;
    private final boolean golden;

    private Card(String type, boolean golden) {
        this.type = type;
        this.golden = golden;
    }

    /**
     * Returns the type of this card.
     *
     * @return Type of the card as String.
     */
    public String getType() {
        return type;
    }

    /**
     * Returns a boolean based on if the card is golden or not
     *
     * @return true if card is golden, false if not.
     */
    public boolean isGolden() {
        return golden;
    }

    /**
     * Parses a card from the given String.
     *
     * @param text The String which the card is parsed from.
     * @return The Card parsed from the String if successful, null if the String
     * does not match any of the Cards types.
     */
    public static Card parseCard(String text) {
        for (Card card : Card.values()) {
            if (text.equals(card.getType())) {
                return card;
            }
        }
        return null;
    }
}
