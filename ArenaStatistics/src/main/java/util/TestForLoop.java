package util;

import domain.DeckClass;
import domain.DeckClassPair;
import java.util.List;
import java.util.Map;

public class TestForLoop {

    private static final List<DeckClass> dclist = DeckClassList.getDeckClassList();

    public static boolean zeroesInDcIntegerMap1ClassException(Map<DeckClass, Integer> map, DeckClass exception) {
        for (DeckClass deckClass : dclist) {
            if (map.get(deckClass) != 0 && deckClass != exception) {
                return false;
            }
        }
        return true;
    }

    public static boolean zeroesInDcIntegerMap2ClassExceptions(Map<DeckClass, Integer> map, DeckClass exception1, DeckClass exception2) {
        for (DeckClass deckClass : dclist) {
            if (map.get(deckClass) != 0 && !(deckClass == exception1 || deckClass == exception2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean zeroesInDcIntegerMap4ClassExceptions(Map<DeckClass, Integer> map, DeckClass ex1,
            DeckClass ex2, DeckClass ex3, DeckClass ex4) {
        for (DeckClass deckClass : dclist) {
            if (map.get(deckClass) != 0 && !(deckClass == ex1 || deckClass == ex2
                    || deckClass == ex3 || deckClass == ex4)) {
                return false;
            }
        }
        return true;
    }

    public static boolean zeroesInDcIntegerMap3ClassExceptions(Map<DeckClass, Integer> map, DeckClass exception1,
            DeckClass exception2, DeckClass exception3) {
        for (DeckClass deckClass : dclist) {
            if (map.get(deckClass) != 0 && !(deckClass == exception1 || deckClass == exception2
                    || deckClass == exception3)) {
                return false;
            }
        }
        return true;
    }

    public static boolean zeroesInDcpIntegerMap1DcpException(Map<DeckClassPair, Integer> map, DeckClassPair exception) {
        for (DeckClass dc1 : dclist) {
            for (DeckClass dc2 : dclist) {
                DeckClassPair dcp = new DeckClassPair(dc1, dc2);
                if (map.get(dcp) != 0 && !dcp.equals(exception)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean zeroesInDcpIntegerMap2DcpExceptions(Map<DeckClassPair, Integer> map,
            DeckClassPair exception1, DeckClassPair exception2) {
        for (DeckClass dc1 : dclist) {
            for (DeckClass dc2 : dclist) {
                DeckClassPair dcp = new DeckClassPair(dc1, dc2);
                if (map.get(dcp) != 0 && !(dcp.equals(exception1) || dcp.equals(exception2))) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean zeroesInDcDoubleMap1ClassException(Map<DeckClass, Double> map, DeckClass exception) {
        for (DeckClass dc : dclist) {
            if (map.get(dc) != 0 && dc != exception) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean zeroesInDcpDoubleMap1DcpException(Map<DeckClassPair, Double> map, DeckClassPair exception) {
        for (DeckClass dc1 : dclist) {
            for (DeckClass dc2 : dclist) {
                DeckClassPair dcp = new DeckClassPair(dc1, dc2);
                if (map.get(dcp) != 0 && !dcp.equals(exception)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean zeroesInDcpIntegerMap(Map<DeckClassPair, Integer> map) {
        for (DeckClass dc1: dclist) {
            for (DeckClass dc2 : dclist) {
                DeckClassPair dcp = new DeckClassPair(dc1, dc2);
                if (map.get(dcp) != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean zeroesInDcIntegerMap(Map<DeckClass, Integer> map) {
        for (DeckClass dc : dclist) {
            if (map.get(dc) != 0) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean zeroesInDcDoubleMap(Map<DeckClass, Double> map) {
        for (DeckClass dc : dclist) {
            if (map.get(dc) != 0) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean zeroesInDcpDoubleMaps(Map<DeckClassPair, Double> map) {
        for (DeckClass dc1 : dclist) {
            for (DeckClass dc2 : dclist) {
                DeckClassPair dcp = new DeckClassPair(dc1, dc2);
                if (map.get(dcp) != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean zeroesInIntegerIntegerMap(Map<Integer, Integer> map) {
        for (int i = 1; i <= 12; i++) {
            if (map.get(i) != 0) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean zeroesInIntegerDoubleMap(Map<Integer, Double> map) {
        for (int i = 1; i <= 12; i++) {
            if (map.get(i) != 0) {
                return false;
            }
        }
        return true;
    }
}
