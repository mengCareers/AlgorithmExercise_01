/* 92. Restore IP Addresses
e.g.
Given "25525511135",
return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * Thought Process:
similar to word break II
 * 
 */
package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class RestoreIPAddresses {

    public static void main(String[] args) {
        List<String> res = new RestoreIPAddresses().restoreIpAddresses("1111");
        System.out.println(res);
    }

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return new ArrayList<>();
        }
        return util(s, 0);
    }

    List<String> util(String s, int cnt) {
        List<String> cur = new ArrayList<>();
        for (int i = 1; i <= s.length(); i++) {
            String sub1 = s.substring(0, i);
            if (isValid(sub1)) {
                if (i == s.length() && cnt == 3) {
                    cur.add(sub1);
                } else {
                    String sub2 = s.substring(sub1.length());
                    List<String> list = util(sub2, cnt + 1);

                    for (String item : list) {
                        cur.add(sub1 + "." + item);
                    }

                }
            }
        }
        return cur;
    }

    boolean isValid(String s) {
        if (s.length() == 0 || s.length() > 3) {
            return false;
        }
        // !
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }

        if (Integer.parseInt(s) > 255) {
            return false;
        }
        return true;
    }
}
