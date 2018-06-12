package lesson1;

public class Main {

    public static double distance(Point p1, Point p2) {
        double d = Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
        return d;
    }

    public static void main(String[] args) {
        Point a = new Point(5, 6);
        Point b = new Point(8, 10);
        System.out.println(Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2)));
        System.out.println(distance(a, b));
        System.out.println(a.distance(a,b));
    }
}