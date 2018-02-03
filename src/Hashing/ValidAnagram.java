package Hashing;

/* 242.Valid Anagram
 * Thought Process: Anagram 同字母可异序
   len must equal
 * Hashing, hash[c]++, check all = 0, return true
 */

/**
 *
 * @author xinrong
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) 
            return false;
        int[] hash = new int[256];
        for (char c : s.toCharArray()) 
            hash[c - '0']++;
        for (char c : t.toCharArray())
            hash[c - '0']--;
        for (int i : hash)
            if (i != 0)
                return false;
        return true;
    }    
}
