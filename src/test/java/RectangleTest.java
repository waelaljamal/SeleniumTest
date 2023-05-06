import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.*;

public class RectangleTest {

    Rectangle rect;

    @Before
    public void Setup()
    {
       rect = new Rectangle(); 
    }

    @Test
    public void baseRectangleTests() {
        
        assertEquals("max of 10, 1 must be 10", 10, rect.maxOfTowIntegers(10, 1));

    }
}
