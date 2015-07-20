
package domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class OutcomeTest {
    
    public OutcomeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void parseOutcome1() {
        assertEquals(Outcome.WIN, Outcome.parseOutcome("Win"));
    }
    
    @Test
    public void parseOutcome2() {
        assertEquals(Outcome.LOSS, Outcome.parseOutcome("Loss"));
    }
    
    @Test
    public void parseOutcome3() {
        assertEquals(Outcome.DISCONNECT, Outcome.parseOutcome("Disconnect"));
    }
    
    @Test
    public void parseOutcome4() {
        assertEquals(null, Outcome.parseOutcome("win"));
    }
    
}
