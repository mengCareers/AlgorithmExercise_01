/*
Orientation of 3 ordered points:
    - counterclockwise
    - clockwise
    - colinear
 * Thought Process:
 * use slope,
k1 = (y2 - y1) / (x2 - x1)
k2 = (y3 - y2) / (x3 - x2)
if (k1 < k2) counterclockwise
if (k1 > k2) clockwise
if (k1 ==k2) colinear
 */
package Geometry;

/**
 *
 * @author xinrong
 */
public class Orientationof3OrderedPoints {

    public static void main(String[] args) {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(4, 4);
        Point p3 = new Point(1, 2);
        // In this case, we can't simply k1 - k2
        int o = getOrientation(p1, p2, p3);

        if (o == 0) {
            System.out.print("Linear");
        } else if (o == 1) {
            System.out.print("Clockwise");
        } else {
            System.out.print("CounterClockwise");
        }

    }

    /**
     *
     * @param p1
     * @param p2
     * @param p3
     * @return 0 if colinear, 1 if clockwise, 2 if counterclockwise
     */
    public static int getOrientation(Point p1, Point p2, Point p3) {
//        int k1 = (p2.y - p1.y) / (p2.x - p1.x);
//        int k2 = (p3.y - p2.y) / (p3.x - p2.x);
        int val = (p3.x - p2.x) * (p2.y - p1.y) - (p2.x - p1.x) * (p3.y - p2.y);
        if (val < 0) {
            return 2;
        }
        if (val == 0) {
            return 0;
        }
        return 1;
    }

    static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
