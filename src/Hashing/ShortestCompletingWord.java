/* 748. Shortest Completing Word
Find the minimum length word from a given dictionary words, 
which has all the letters from the string licensePlate. 
Such a word is said to complete the given string licensePlate
Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.
It is guaranteed an answer exists. 
If there are multiple answers, return the one that occurs first in the array.
 * Thought Process:
=> Build hash[] from licensePlate by washLicensePlate()
=> For each word in words, we check if it completes licensePlate with the help of checkCompleting()
=> If a word with the length that already exists in the result Map completingWord<key : wordLength, value: word>, we do not need to check it for we only need the shortest one first met.
 * 
 */
package Hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xinrong
 */
public class ShortestCompletingWord {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] hash = washLicensePlate(licensePlate);
        Map<Integer, String> completingWord = new HashMap<>();
        for (String word : words) {
            if (completingWord.containsKey(word.length())) {
                continue;
            }
            int[] copyHash = Arrays.copyOf(hash, hash.length);
            for (char c : word.toCharArray()) {
                copyHash[c - 'a']--;
            }
            if (checkCompleting(copyHash)) {
                completingWord.put(word.length(), word);
            }
        }
        int mink = Integer.MAX_VALUE;
        for (int k : completingWord.keySet()) {
            mink = Math.min(mink, k);
        }
        return completingWord.get(mink);
    }

    private boolean checkCompleting(int[] hash) {
        for (int i : hash) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }

    private int[] washLicensePlate(String licensePlate) {
        int[] hash = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                if (c >= 'a' && c <= 'z') {
                    hash[c - 'a']++;
                }
            }
        }
        return hash;
    }
}
