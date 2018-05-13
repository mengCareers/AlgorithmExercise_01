/* 475.Heaters
input : positions of houses and heaters on a horizontal line
output: minimum radius of heaters so that all houses could be covered
 * Thought Process:
 * Binary Search,
 * Get:
decent Arrays.binarySearch()
for each house, find its position between those heaters
calculate the distances between the house and heaters around, and get min [corner]
get max vale among distances in above step
 */
package Searching;

import java.util.Arrays;

/**
 *
 * @author xinrong
 */
public class Heaters {

    public int findRadius(int[] houses, int[] heaters) {
        int minRadius = 0;
        Arrays.sort(heaters);
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = -(index + 1); // to be inserted
            }
            int leftDist = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
            int rightDist = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
            minRadius = Math.max(minRadius, Math.min(leftDist, rightDist));
        }
        return minRadius;
    }
}
