package domain;

public enum DeckClass {

    DRUID("Druid", "Druid1.jpg", ""),
    HUNTER("Hunter", "Hunter1.jpg", "Hunter2.jpg"),
    MAGE("Mage", "Mage1.jpg", "Mage2.jpg"),
    PALADIN("Paladin", "Mage1.jpg", ""),
    PRIEST("Priest", "Priest1.jpg", ""),
    ROGUE("Rogue", "Rogue1.jpg", ""),
    SHAMAN("Shaman", "Shaman1.jpg", ""),
    WARLOCK("Warlock", "Warlock1.jpg", ""),
    WARRIOR("Warrior", "Warrior1.jpg", "Warrior2.jpg");

    private final String name;
    private final String portraitFilepath;
    private final String altPortraitFilePath;

    private DeckClass(String name, String portraitFilepath, String altPortraitFilePath) {
        this.name = name;
        this.portraitFilepath = portraitFilepath;
        this.altPortraitFilePath = altPortraitFilePath;
    }

    public String getName() {
        return name;
    }

    public String getPortraitFilepath() {
        return portraitFilepath;
    }

    public String getAltPortraitFilePath() {
        return altPortraitFilePath;
    }
    
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
