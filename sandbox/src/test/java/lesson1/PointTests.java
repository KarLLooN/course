package lesson1;

import org.testng.Assert;
import org.testng.annotations.Test;

import static lesson1.Main.distance;

public class PointTests {

    @Test
    public void testPoint(){
        Point point = new Point(78,5);
        Point point1 = new Point(55,8);
        Assert.assertEquals(point.distance(point1),23.194827009486403);
        Assert.assertEquals(distance(point, point1),23.194827009486403);

    }
}