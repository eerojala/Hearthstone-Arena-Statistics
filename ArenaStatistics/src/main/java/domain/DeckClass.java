package domain;

public enum DeckClass {

    DRUID("Druid", "Druid1.png", ""),
    HUNTER("Hunter", "Hunter1.png", "Hunter2.png"),
    MAGE("Mage", "Mage1.png", "Mage2.png"),
    PALADIN("Paladin", "Paladin1.png", ""),
    PRIEST("Priest", "Priest1.png", ""),
    ROGUE("Rogue", "Rogue1.png", ""),
    SHAMAN("Shaman", "Shaman1.png", ""),
    WARLOCK("Warlock", "Warlock1.png", ""),
    WARRIOR("Warrior", "Warrior1.png", "Warrior2.png");

    private final String name;
    private final String portraitFilename;
    private final String alPortraitFilename;
    
    private DeckClass(String name, String portraitFilepath, String altPortraitFilePath) {
        this.name = name;
        this.portraitFilename = portraitFilepath;
        this.alPortraitFilename = altPortraitFilePath;
    }

    public String getName() {
        return name;
    }

    public String getPortraitFilename() {
        return portraitFilename;
    }

    public String getAlPortraitFilename() {
        return alPortraitFilename;
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
