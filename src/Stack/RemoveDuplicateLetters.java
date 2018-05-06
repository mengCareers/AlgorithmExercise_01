/* 316. Remove Duplicate Letters
Q : Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 * Thought Process:
With the help of stack, for each char ch in s : 
If stack contains ch => continue
while ( ch < peek) and  ( peak appears again after ch ) => pop
push ch to stack

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
        if (s == null || s.length() == 0) {
            return s;
        }
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        --freq[s.charAt(0) - 'a'];
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            --freq[ch - 'a'];
            if (stack.contains(ch)) {
                continue;
            }
            while (!stack.isEmpty() && freq[stack.peek() - 'a'] > 0 && ch < stack.peek()) {
                stack.pop();
            }
            stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
