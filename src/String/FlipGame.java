package String;


import java.util.ArrayList;
import java.util.List;

/*
 *  Q:293.Flip Game
input : s contains only + -
output: all pos after change one ++ to --
 *  Thought Process: 
iterate s, 
e.g. ... +  + ...
        i-1 i
to   ... -  - ...
 *  Get:
 */

/**
 *
 * @author xinrong
 */
public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<>();
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == '+' && s.charAt(i) == '+') {
                res.add(s.substring(0, i - 1) + "--" + s.substring(i + 1));
            }
        }
        return res;
    }    
}
