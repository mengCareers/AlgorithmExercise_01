/* 739.Daily Temperatures
output: a list that for each day in the input, tells how many days would have to wait
        until a warmer temperature, or 0 if not possible
 * Thought Process:
for each element, tells the index distance between itself and its next greater elements
We use a stack to store indices of elements in the array temperatures. Stack related problem is always about to put the current element into the right position in order to construct the final answer.
We loop through temperatures[],
when current element is bigger than temperatures[stack.peek()], we keep popping from stack and calculate the corresponding answer, i.e., idx = indexStack.pop(), result[idx] = i - idx.
we push the current element's index into the stack.
 */
package Heap;

import java.util.Stack;

/**
 *
 * @author xinrong
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        DailyTemperatures inst = new DailyTemperatures();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] res = inst.dailyTemperatures(temperatures);
        printArray(res);
    }

    private static void printArray(int[] arr) {
        for (int ele : arr) {
            System.out.print(ele + ", ");
        }
        System.out.println();
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> indexStack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!indexStack.empty() && temperatures[i] > temperatures[indexStack.peek()]) {
                int idx = indexStack.pop();
                result[idx] = i - idx;
            }
            indexStack.push(i);
        }
        while (!indexStack.empty()) {
            result[indexStack.pop()] = 0;
        }
        return result;
    }
}
