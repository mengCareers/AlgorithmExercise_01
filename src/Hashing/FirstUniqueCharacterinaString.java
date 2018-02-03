package Hashing;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
input : s
output: index of first uniq char 
        -1 if not exist
 * Thought Process:
- How to find uniq chars?
hashing, map<char, list of indices>
whoes indices.size = 1, is uniq char
return min index
 * 
 */

/**
 *
 * @author xinrong
 */
public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == null) 
                map.put(c, new ArrayList<>());
            map.get(c).add(i);
        }
        int min = Integer.MAX_VALUE;
        for (char c : map.keySet()) {
            if (map.get(c).size() == 1) {
                min = Math.min(min, map.get(c).get(0));
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }    
}
