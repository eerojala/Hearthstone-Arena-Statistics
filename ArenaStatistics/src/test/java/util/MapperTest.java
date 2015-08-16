package util;

import domain.DeckClass;
import domain.DeckClassPair;
import domain.Match;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class MapperTest {
    Map<DeckClass,Integer> dcIntegerMap;
    Map<DeckClassPair, Integer> dcpIntegerMap;
    Map<DeckClass, Double> dcDoubleMap;
    Map<DeckClassPair, Double> dcpDoubleMap;
    Map<Integer, Integer> integerIntegerMap;
    Map<Integer, Double> integerDoubleMap;
    boolean bool;
    
    public MapperTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        dcIntegerMap = new HashMap();
        dcpIntegerMap = new HashMap();
        dcDoubleMap = new HashMap();
        dcpDoubleMap = new HashMap();
        integerIntegerMap = new HashMap();
        integerDoubleMap = new HashMap();
        bool = true;
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void mapZeroesToADeckClassIntegerMap_has_correct_keyset_size() {
        Mapper.mapZeroesToADeckClassIntegerMap(dcIntegerMap);
        assertEquals(9, dcIntegerMap.keySet().size());
    }
    
    @Test
    public void mapZeroesToADeckClassIntegerMap_values_are_zeroes() {
        Mapper.mapZeroesToADeckClassIntegerMap(dcIntegerMap);
        assertTrue(TestForLoop.zeroesInDcIntegerMap(dcIntegerMap));
    }
    
    @Test
    public void mapZeroesToADeckClassPairIntegerMap_has_correct_keyset_size() {
        Mapper.mapZeroesToADeckClassPairIntegerMap(dcpIntegerMap);
        assertEquals(81, dcpIntegerMap.keySet().size());
    }
    
    @Test
    public void mapZeroesToADeckClassPairIntegerMap_values_are_zeroes() {
        Mapper.mapZeroesToADeckClassPairIntegerMap(dcpIntegerMap);
        assertTrue(TestForLoop.zeroesInDcpIntegerMap(dcpIntegerMap));
    }
}
