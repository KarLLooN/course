package lesson1;

import org.testng.Assert;
import org.testng.annotations.Test;

import static lesson1.Main.distance;

public class PointTests {

    @Test
    public void testPoint(){
        Point point = new Point(78,5);
        Point point1 = new Point(55,8);
        double distance = (Math.sqrt(Math.pow(point.x - point1.x, 2) + Math.pow(point.y - point1.y, 2)));
        Assert.assertEquals(point.distance(point1),distance);
        Assert.assertEquals(distance(point, point1),distance);

    }
}