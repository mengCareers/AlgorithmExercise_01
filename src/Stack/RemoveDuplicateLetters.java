/* 316. Remove Duplicate Letters
If ($ < #) and (# appears again after $) => we remove #.
 * Thought Process:
 * 
 */
package Stack;

import java.util.Stack;

/**
 *
 * @author xinrong
 */
public class RemoveDuplicateLetters {

    public static void main(String[] args) {
        String ans = removeDuplicateLetters("cbacdcbc");
        System.out.println(ans);
    }

    public static String removeDuplicateLetters(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        Stack<Character> stack = new Stack<>();
        int[] freq = new int[256];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        stack.push(s.charAt(0));
        freq[s.charAt(0)]--;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c]--;
            if (stack.contains(c)) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && freq[stack.peek()] > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
