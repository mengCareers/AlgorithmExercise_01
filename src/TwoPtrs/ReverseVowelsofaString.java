package TwoPtrs;


import java.util.HashSet;
import java.util.Set;

/* 345. Reverse Vowels of a String
input: str
output:str reversed only the vowels
 * Thought Process:
if leetcode,
vowel: e e o e
       1 2 5 7
reverse: e o e e
         1 2 5 7
relace with
 * 
 */

/**
 *
 * @author xinrong
 */
public class ReverseVowelsofaString {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        int start = 0, end = s.length() - 1;
        char[] chars = s.toCharArray();
        
        while (start < end) {
            while (start < end && !vowels.contains(chars[start])) 
                start++;
            while (start < end && !vowels.contains(chars[end]))
                end--;
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        } 
        return new String(chars);
    }
    public static void main(String[] args) {
        String ans = new ReverseVowelsofaString().reverseVowels("leetcode");
        System.out.println(ans);
    }
}
