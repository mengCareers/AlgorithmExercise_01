/* 503. Next Greater Element II
Given a circular array (the next element of the last element is the first element of the array), 
print the Next Greater Number for every element. 
The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, 
which means you could search circularly to find its next greater number. 
If it doesn't exist, output -1 for this number.
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number; 
The second 1's next greater number needs to search circularly, which is also 2.
 * Thought Process:
Except for the biggest, others can find next greater number circularly.
For the biggest, it is -1
 * Get :
Since it is a circular array, we iterate it twice to immutate a complete traversal.
We store indices in stack rather than values for there may be duplicate values in the array.
Stack keeps popping elements as long as the current element in nums is greater, and then, push current element into the stack. 
During the 'popping', we keep the answer in the map nextGreater, such that index as the key, nextGreaterElement as the value.
 */
package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author xinrong
 */
public class NextGreaterElementII {

    public int[] nextGreaterElementsModuler(int[] nums) {
        int[] result = new int[nums.length];
        // if i = 2, nums.length = 5, j [1, 4]
        // 3 4 0 1 
        for (int i = 0; i < nums.length; i++) {
            result[i] = -1;
            for (int j = 1; j < nums.length; j++) {
                if (nums[(i + j) % nums.length] > nums[i]) {
                    result[i] = nums[(i + j) % nums.length];
                    break;
                }
            }
        }
        return result;
    }

    public int[] nextGreaterElementsDoublenums(int[] nums) {
        int[] result = new int[nums.length];
        int[] doublenums = new int[nums.length * 2];
        // 3
        // [0, 3)
        // [3, 6)
        System.arraycopy(nums, 0, doublenums, 0, nums.length);
        System.arraycopy(nums, 0, doublenums, nums.length, nums.length);
        for (int i = 0; i < nums.length; i++) {
            result[i] = -1;
            for (int j = i + 1; j < doublenums.length; j++) {
                if (doublenums[j] > doublenums[i]) {
                    result[i] = doublenums[j];
                    break;
                }
            }
        }
        return result;
    }

    public int[] nextGreaterElementsStack(int[] nums) {
        int[] result = new int[nums.length];
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    int idx = stack.pop();
                    nextGreater.put(idx, nums[i]);
                }
            }
            stack.push(i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    int idx = stack.pop();
                    nextGreater.put(idx, nums[i]);
                }
            }
            stack.push(i);
        }
        for (int i = 0; i < nums.length; i++) {
            result[i] = -1;
            if (nextGreater.containsKey(i)) {
                result[i] = nextGreater.get(i);
            }
        }
        return result;
    }
}
