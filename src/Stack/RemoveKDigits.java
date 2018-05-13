/* 402. Remove K Digits
Given a non-negative integer num represented as a string, 
remove k digits from the number so that the new number is the smallest possible.
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes. 
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
* Thought Process:
 * find the largest digit,
 * if prev zero, remove first non-zero moving right
 * if prev not zero, remove it
* Get:
 whenever meet a digit smaller than the prev one
 for only keep the smallest (len - k)
 and remain the order
 so we use stack
We aim to keep the smallest num.length() - k digits and remain their relative order.
Stack is good in this case.
So we keep popping from the stack if the current digit met is smaller, and then push current digit to the right position.
Afterwards, we construct number using the stack and remove the leading 0s.
 */
package Stack;

import java.util.Stack;

/**
 *
 * @author xinrong
 */
public class RemoveKDigits {
    
    public static void main(String[] args) {
        RemoveKDigits inst = new RemoveKDigits();
        String num = "1234567890";
        int k = 9;
        String res = inst.removeKdigits(num, k);
        System.out.println(res);
    }

    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        int ni = 0;
        while (ni < num.length()) {
            while (k > 0 && !stack.isEmpty() && num.charAt(ni) < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(ni));
            ni++;
        }
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        return constructNumber(stack);
    }

    private String constructNumber(Stack stack) {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        System.out.println(sb);
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
