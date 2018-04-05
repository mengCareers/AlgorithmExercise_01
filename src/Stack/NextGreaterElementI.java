/*
 * Thought Process:
before push x to map
    while  x bigger than peek, pop, and save in map 
 * 
 */
package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author xinrong\
 */
public class NextGreaterElementI {

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 2, 3, 4};
        int[] res = new NextGreaterElementI().nextGreaterElement(nums1, nums2);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> resMap = new HashMap<>();
        for (int ni : nums2) {
            while (!stack.empty() && stack.peek() < ni) {
                resMap.put(stack.pop(), ni);
            }
            stack.push(ni);
        }
        for (int i = 0; i < nums1.length; i++) {
            if (resMap.containsKey(nums1[i])) {
                res[i] = resMap.get(nums1[i]);
            } else {
                res[i] = -1;
            }

        }
        return res;
    }

// *                             _ooOoo_
// *                            o8888888o
// *                            88" . "88
// *                            (| -_- |)   
// *                            O\  =  /O   NAIVE
// *                         ____/`---'\____
// *                       .'  \\|     |//  `.
// *                      /  \\|||  :  |||//  \
// *                     /  _||||| -:- |||||-  \
// *                     |   | \\\  -  /// |   |
// *                     | \_|  ''\---/''  |   |
// *                     \  .-\__  `-`  ___/-. /
// *                   ___`. .'  /--.--\  `. . __
// *                ."" '<  `.___\_<|>_/___.'  >'"".
// *               | | :  `- \`.;`\ _ /`;.`/ - ` : | |
// *               \  \ `-.   \_ __\ /__ _/   .-` /  /
// *          ======`-.____`-.___\_____/___.-`____.-'====== 
    public int[] NAIVEnextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> helpStack = new Stack<>();
        for (int ni2 : nums2) {
            stack.push(ni2);
        }
        int ri = 0;
        for (int ni : nums1) {
            res[ri++] = getPos(ni, stack, helpStack);
        }
        return res;
    }

    private int getPos(int ni, Stack<Integer> stack, Stack<Integer> helpStack) {
        int ans = 0;
        while (!stack.isEmpty()) {
            if (stack.peek() == ni) {
                while (!helpStack.isEmpty()) {
                    if (helpStack.peek() > ni) {
                        ans = helpStack.peek();
                        recover(stack, helpStack);
                        return ans;
                    } else {
                        stack.push(helpStack.pop());
                    }
                }
                return -1;
            }
            helpStack.push(stack.pop());
        }
        recover(stack, helpStack);
        return -1;
    }

    private void recover(Stack<Integer> stack, Stack<Integer> helpStack) {
        while (!helpStack.isEmpty()) {
            stack.push(helpStack.pop());
        }
    }
}
