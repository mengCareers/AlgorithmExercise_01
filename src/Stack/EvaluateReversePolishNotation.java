/* 150. Evaluate Reverse Polish Notation
 * Thought Process:
 * 
 */
package Stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 *
 * @author xinrong
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Set<Character> set = new HashSet<>();
        set.add('+');
        set.add('-');
        set.add('*');
        set.add('/');

        List<Integer> ilist = new ArrayList<>();
        for (String s : tokens) {
            char c = 0;
            if (s.length() == 1) {
                c = s.charAt(0);

                if (set.contains(c)) {
                    int b = ilist.remove(ilist.size() - 1);
                    int a = ilist.remove(ilist.size() - 1);
                    int r = 0;
                    if (c == '+') {
                        r = a + b;
                    } else if (c == '-') {
                        r = a - b;
                    } else if (c == '*') {
                        r = a * b;
                    } else {
                        r = a / b;
                    }
                    ilist.add(r);
                } else {
                    ilist.add(c - '0');
                }
            } else {
                int ci = Integer.valueOf(s);
                ilist.add(ci);
            }
        }
        return ilist.get(0);
    }

}
