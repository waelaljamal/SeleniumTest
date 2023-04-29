import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.*;

public class MaxValueSimpleTest {

    MaxValueSimple MVS;

    @Before
    public void Setup()
    {
       MVS = new MaxValueSimple(); 
    }

    @Test
    public void baseMultiplicationTests() {
        // all positive
        assertEquals("max of 10, 1 must be 10", 10, MVS.maxOfTowIntegers(10, 1));
        assertEquals("max of 1, 10 must be 10", 10, MVS.maxOfTowIntegers(1, 10));
        assertEquals("max of 10, 10 must be 10", 10, MVS.maxOfTowIntegers(10, 10));
        assertEquals("max of 1, 1 must be 1", 1, MVS.maxOfTowIntegers(1, 1));
        assertEquals("max of 0, 1 must be 1", 1, MVS.maxOfTowIntegers(0, 1));
        assertEquals("max of 1, 0 must be 1", 1, MVS.maxOfTowIntegers(1, 0));
        assertEquals("max of 0, 0 must be 0", 0, MVS.maxOfTowIntegers(0, 0));

        // all negative
        assertEquals("max of -10, -1 must be -1", -1, MVS.maxOfTowIntegers(-10, -1));
        assertEquals("max of -1, -10 must be -1", -1, MVS.maxOfTowIntegers(-1, -10));
        assertEquals("max of -10, -10 must be -10", -10, MVS.maxOfTowIntegers(-10, -10));
        assertEquals("max of -1, -1 must be -1", -1, MVS.maxOfTowIntegers(-1, -1));
        
        // positive and negative
        assertEquals("max of 10, -10 must be 10", 10, MVS.maxOfTowIntegers(10, -10));
        assertEquals("max of -10, 10 must be 10", 10, MVS.maxOfTowIntegers(-10, 10));
        assertEquals("max of 1, -1 must be 1", 1, MVS.maxOfTowIntegers(1, -1));
        assertEquals("max of -1, 1 must be 1", 1, MVS.maxOfTowIntegers(-1, 1));
        assertEquals("max of 0, -1 must be 0", 0, MVS.maxOfTowIntegers(0, -1));
        assertEquals("max of -1, 0 must be 0", 0, MVS.maxOfTowIntegers(-1, 0));
    }
}
