package util;

import domain.Deck;
import domain.DeckClass;
import domain.Matchup;
import java.util.Map;
import xml.DeckParser;
import xml.XmlWriter;

public class TestHelper {

    private static final DeckClass[] dcArray = DeckClass.values();

    public static boolean zeroesInDcIntMap(Map<DeckClass, Integer> map, DeckClass... exceptions) {
        for (DeckClass dc : dcArray) {
            if (map.get(dc) != 0 && !objectIsAnException(dc, (Object[]) exceptions)) {
                return false;
            }
        }
        return true;
    }

    private static boolean objectIsAnException(Object o, Object... exceptions) {
        for (Object exception : exceptions) {
            if (o.equals(exception)) {
                return true;
            }
        }
        return false;
    }

    public static boolean zeroesInDcpIntMap(Map<Matchup, Integer> map, Matchup... exceptions) {
        for (DeckClass dc1 : dcArray) {
            for (DeckClass dc2 : dcArray) {
                Matchup dcp = new Matchup(dc1, dc2);
                if (map.get(dcp) != 0 && !objectIsAnException(dcp, (Object[]) exceptions)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean zeroesInDcDoubleMap(Map<DeckClass, Double> map, DeckClass... exceptions) {
        for (DeckClass dc : dcArray) {
            if (map.get(dc) != 0 && !objectIsAnException(dc, (Object[]) exceptions)) {
                return false;
            }
        }
        return true;
    }

    public static boolean zeroesInDcpDoubleMap(Map<Matchup, Double> map, Matchup... exceptions) {
        for (DeckClass dc1 : dcArray) {
            for (DeckClass dc2 : dcArray) {
                Matchup dcp = new Matchup(dc1, dc2);
                if (map.get(dcp) != 0 && !objectIsAnException(dcp, (Object[]) exceptions)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean zeroesInIntIntMap(Map<Integer, Integer> map, int... exceptions) {
        for (int i = 0; i < 13; i++) {
            if (map.get(i) != 0 && !integerIsAnException(i, exceptions)) {
                return false;
            }
        }
        return true;
    }

    private static boolean integerIsAnException(int integer, int... exceptions) {
        for (Integer exception : exceptions) {
            if (integer == exception) {
                return true;
            }
        }
        return false;
    }

    public static boolean zeroesInIntDoubleMap(Map<Integer, Double> map, int... exceptions) {
        for (int i = 0; i < 13; i++) {
            if (map.get(i) != 0 && !integerIsAnException(i, exceptions)) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean zeroesInDcIntIntMapMap(Map<DeckClass, Map<Integer, Integer>> map) {
        for (DeckClass dc : DeckClass.values()) {
            if (!zeroesInIntIntMap(map.get(dc))) {
                return false;
            }
        }
        return true;
    }
    
    public static Deck writeAndParseDeck(XmlWriter writer, String parseFilepath, Deck deck) {
        writer.writeContent(deck);
        DeckParser parser = new DeckParser(parseFilepath);
        parser.addValues();
        return parser.getDeck();
    }
}
