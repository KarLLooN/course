package lesson1;

public class Main {

    public static double distance(Point p1, Point p2) {
        double d = Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
        return d;
    }

    public static void main(String[] args) {
        Point p1 = new Point(78, 5);
        Point p2 = new Point(55, 8);
        System.out.println(Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2)));
        System.out.println(distance(p1, p2));
        System.out.println(p1.distance(p2));
    }
}