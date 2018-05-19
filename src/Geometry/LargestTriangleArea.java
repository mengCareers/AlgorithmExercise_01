/* 812.Largest Triangle Area
input : list of points in the plane
output: area of the largest triangle formed by any 3 of the points
 * Thought Process:
 * Brute Force, try 3 by 3
 * Hint :
How many loops do we need to cycle through each choice of 3 points? 3
How do we calculate the area given 3 points?
 */
package Geometry;

/**
 *
 * @author xinrong
 */
public class LargestTriangleArea {

    public double largestTriangleArea(int[][] points) {
        double area = 0.0;
        for (int[] a : points) {
            for (int[] b : points) {
                for (int[] c : points) {
                    area = Math.max(area, 
                                   0.5 * (a[0] * b[1] + b[0] * c[1] + c[0] * a[1] - a[0] * c[1] - c[0] * b[1] - b[0] * a[1]));
                }
            }
        }
        return area;
    }
}
