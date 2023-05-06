import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.*;

public class RectangleTest {

    Rectangle rect;
    double Delta = 0.0001;

    @Test
    public void baseRectangleTests() throws RectangleException {

        // create normal rect object with valid lengths
        Rectangle rect = new Rectangle(2, 3);

        // read edges lengths - test getters
        //System.out.println("A: " + Double.toString(rect.getA()));
        assertEquals("getA must return 2", 2.0, rect.getA(), Delta);
        //System.out.println("B: " + Double.toString(rect.getB()));
        assertEquals("getB must return 3", 3.0, rect.getB(), Delta);

        // test getArea method
        //System.out.println("Area: " + Double.toString(rect.getArea()));
        assertEquals("getArea must restrns a*b = 2*3 = 6", 6.0, rect.getArea(), Delta);

        // test getPerimeter method
        //System.out.println("Perimeter: " + Double.toString(rect.getPerimeter()));
        assertEquals("getPerimeter must returns 2*a+2*b = 2*2+2*3 = 10", 10.0, rect.getPerimeter(), Delta);

        // a = 2, b = 3 test isSquare with not equal edges
        assertEquals("isSquare for a != b, 2 != 3", false, rect.isSquare());
        //System.out.println("isSquare: " + Boolean.toString(rect.isSquare()));

        // update edges lengths - test setters && getters
        rect.setA(5);
        rect.setB(5);
        assertEquals("getA must return 5", 5, rect.getA(), Delta);
        assertEquals("getB must return 5", 5, rect.getB(), Delta);
        
        // a = 5, b = 5 test isSquare with  equal edges
        //System.out.println("isSquare: " + Boolean.toString(rect.isSquare()));
        assertEquals("isSquare for a = b, 5 = 5", true, rect.isSquare());
   }

    // exceptions testing
    // create a rect object with invalid lengths

    @Test(expected = RectangleException.class)
    public void baseRectangleTests_invalid_length_1() throws RectangleException {

        Rectangle rect = new Rectangle(0, 3);
    }
    @Test(expected = RectangleException.class)
    public void baseRectangleTests_invalid_length_2() throws RectangleException {

        Rectangle rect = new Rectangle(3, 0);
    }
    @Test(expected = RectangleException.class)
    public void baseRectangleTests_invalid_length_3() throws RectangleException {

        Rectangle rect = new Rectangle(-6, 3);
    }
    @Test(expected = RectangleException.class)
    public void baseRectangleTests_invalid_length_4() throws RectangleException {

        Rectangle rect = new Rectangle(7, -7);
    }
}
