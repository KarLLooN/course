package lesson1;

public class Main {


    public static void main(String[] args) {
        Point a = new Point(5, 6);
//        a.x = 5;
//        a.y = 6;
        Point b = new Point(8,10);
//        b.x = 8;
//        b.y = 10;
        System.out.println(Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2)));
        System.out.println(Point.distance(new Point(5,6), new Point(8,10)));

    }
}