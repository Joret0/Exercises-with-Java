package square_test;

import org.junit.Assert;
import org.junit.Test;
import square.Rectangle;
import square.Square;

public class RectangleTests {

    @Test
    public void getSidesTest() {
        Rectangle rectangle = new Rectangle(10 , 5);
        Assert.assertEquals(10, rectangle.getWidth());
        Assert.assertEquals(5, rectangle.getHeight());
    }

    @Test
    public void getAreaTest() {
        Rectangle rectangle = new Rectangle(5, 10);
        Assert.assertEquals(50, rectangle.getArea());
    }

    @Test
    public void getSquareTest() {
        Rectangle square = new Square(10);
        Assert.assertEquals(100, square.getArea());
    }
}
