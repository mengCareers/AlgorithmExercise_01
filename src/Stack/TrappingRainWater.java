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

    /*How do we trap water ? h1 > h && h < h4, and S, the water trapped, should be decided by min(h1, h4)
h1 _            Thus, we use stack save decreasing heights until meet a higher height h4, pop one and accumulate S until h1 > h3
    |    _ h4     we save index instead of height
    |_  |
  h2  |_| 
        h3
      
    
     */
    public int trapSelf(int[] height) {
        int wi = 0;
        Stack<Integer> stack = new Stack<>();
        int S = 0;
        while (wi < height.length) {
            while (!stack.empty() && height[wi] > height[stack.peek()]) {
                int w3 = stack.pop();
                if (stack.empty()) {
                    break;
                }
                int w2 = stack.peek();
                int h = Math.min(height[w2], height[wi]) - height[w3];
                int w = wi - w2 - 1;
                S += h * w;
            }
            stack.push(wi);
            wi++;
        }
        return S;
    }

    public int trap(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.empty() && height[stack.peek()] < height[i]) {
                int top = stack.pop();
                if (stack.empty()) {
                    break;
                }
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
