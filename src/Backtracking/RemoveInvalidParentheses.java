import java.util.Queue;
import java.util.LinkedList;
import java.util.*;

/**
 * Q: remove minimum # of parentheses to make str valid
 * generate all possible output: backtrack among all states by removing ( or ) and chk if valid
 *  if invalid, add removed back and go for next state
 *  BFS for moving through states (assure minimum #)
 */
public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        new RemoveInvalidParentheses().removeParentheses("()())()");
    }

    public void removeParentheses(String str) {
        Set<String> set = new HashSet<>(); // visited        
        Queue<String> q = new LinkedList<>(); // bfs      
        List<String> res =  new ArrayList<>();
        q.add(str);
        set.add(str);
        
        boolean lvl = false; 
        // what same characteristic does the same lvl candidates share
        // same # of func calls
        
        while (!q.isEmpty()) {
            str = q.poll();
            if (isValid(str)) {
                System.out.println(str);
                lvl = true;
            }
            if (lvl)
                continue;
            for (int i = 0; i < str.length(); i++) {
                if (!isParenthesis(str.charAt(i)))
                    continue;
                String tmp = str.substring(0, i) + str.substring(i + 1);
                if (!set.contains(tmp)) {
                    q.add(tmp);
                    set.add(tmp);
                }
            }
        }
    }

    public boolean isValid(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                cnt ++;
            else if (str.charAt(i) == ')')
                cnt --;
            if (cnt < 0)
                return false;
        }
        return cnt == 0;
    }

    public boolean isParenthesis(char c) {
        return ((c == '(') || (c == ')'));
    }
}