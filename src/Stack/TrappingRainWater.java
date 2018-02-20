/* 42. Trapping Rain Water
input : int[] height
output: # of water trapped
 * Thought Process:
 * 
 */
package Stack;

import java.util.Stack;

/**
 *
 * @author xinrong
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {2, 0, 2};
        int s = new TrappingRainWater().trap(height);
        System.out.println(s);
    }
    public int trap(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {       
            while (!stack.empty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();
                if (stack.empty())
                    break;
                int stop = stack.peek();
                int h = Math.min(height[stop], height[i]) - height[top];
                int w = i - stop - 1;
                res += h * w;
            }
            stack.push(i);
        }
        return res;
    }    
}
