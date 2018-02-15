/* 11.Container With Most Water
 * Thought Process:
 * 
 */
package Searching;

/**
 *
 * @author xinrong
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxs = Integer.MIN_VALUE;
        int i = 0, k = height.length - 1;
        
        while (i < k) {            
            if (height[i] > height[k]) {
                int s = (k - i) * height[k];
                maxs = Math.max(s, maxs);
                k--;
            }
            else {
                int s = (k - i) * height[i];
                maxs = Math.max(s, maxs);
                i++;
            }
        }
        
        return maxs;
    }    
}
