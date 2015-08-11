
package util;

import domain.DeckClass;
import java.util.ArrayList;
import java.util.List;

public class DeckClassList {
    public static List<DeckClass> getDeckClassList() {
        List<DeckClass> list = new ArrayList();
        list.add(DeckClass.DRUID);
        list.add(DeckClass.HUNTER);
        list.add(DeckClass.MAGE);
        list.add(DeckClass.PALADIN);
        list.add(DeckClass.PRIEST);
        list.add(DeckClass.ROGUE);
        list.add(DeckClass.SHAMAN);
        list.add(DeckClass.WARLOCK);
        list.add(DeckClass.WARRIOR);
        return list;
    }
}
