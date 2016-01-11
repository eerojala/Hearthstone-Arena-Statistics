package domain;

/**
 * Enum representing the deck classes of Hearthstone.
 */
public enum DeckClass {

    /**
     * Enum representing the Druid class.
     */
    DRUID("Druid", "Druid1.png", ""),
    /**
     * Enum representing the Hunter class.
     */
    HUNTER("Hunter", "Hunter1.png", "Hunter2.png"),
    /**
     * Enum representing the Mage class.
     */
    MAGE("Mage", "Mage1.png", "Mage2.png"),
    /**
     * Enum representing the Paladin class.
     */
    PALADIN("Paladin", "Paladin1.png", ""),
    /**
     * Enum representing the Priest class.
     */
    PRIEST("Priest", "Priest1.png", ""),
    /**
     * Enum representing the Rogue class.
     */
    ROGUE("Rogue", "Rogue1.png", ""),
    /**
     * Enum representing the Shaman class.
     */
    SHAMAN("Shaman", "Shaman1.png", ""),
    /**
     * Enum representing the Warlock class.
     */
    WARLOCK("Warlock", "Warlock1.png", ""),
    /**
     * Enum representing the Warrior class.
     */
    WARRIOR("Warrior", "Warrior1.png", "Warrior2.png");

    private final String name;
    private final String portraitFilename;
    private final String alPortraitFilename;

    private DeckClass(String name, String portraitFilepath, String altPortraitFilePath) {
        this.name = name;
        this.portraitFilename = portraitFilepath;
        this.alPortraitFilename = altPortraitFilePath;
    }

    /**
     * Returns the name of the class.
     *
     * @return Name of the class as String.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the filename of the class' main portrait.
     *
     * @return Filename of the main portrait as String.
     */
    public String getPortraitFilename() {
        return portraitFilename;
    }

    /**
     * Returns the filename of the class' alternate portrait.
     *
     * @return Filename of the main portrait as String. If the class does not
     * have an alternate portrait, the method returns an empty String.
     */
    public String getAlPortraitFilename() {
        return alPortraitFilename;
    }

    /**
     * Parses a DeckClass out of the given String.
     *
     * @param text String from which the DeckClass is parsed.
     *
     * @return DeckClass parsed from the String, null if the String does not
     * match any of the classes' names.
     */
    public static DeckClass parseDeckClass(String text) {;
        for (DeckClass deckClass : DeckClass.values()) {
            if (text.equals(deckClass.getName())) {
                return deckClass;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}
