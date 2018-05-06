/* 318. Maximum Product of Word Lengths
input : words
output: max len(words[i]) * len(words[j]) such that words[i] and words[j] not share common letters
        or 0
 * Thought Process:
nums[i] represents which char exists in words[i]
if (nums[i] & nums[j]) == 0, no common chars between words[i] and words[j]

 * 
 */
package BitManipulation;

/**
 *
 * @author xinrong
 */
public class MaximumProductofWordLengths {

    public static void main(String[] args) {
        String word = "ab";
        int num = 0;
        for (char ch : word.toCharArray()) {
            num |= 1 << (ch - 'a'); // represent if a char exists in the word
        }
        System.out.println(num);
    }

    public int maxProduct(String[] words) {
        int len = words.length, maxProductLens = 0;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = 0;
            for (char ch : words[i].toCharArray()) {
                nums[i] |= 1 << (ch - 'a'); // represent if a char exists in the word
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if ((nums[i] & nums[j]) == 0) {
                    maxProductLens = Math.max(maxProductLens, words[i].length() * words[j].length());
                }
            }
        }
        return maxProductLens;
    }
}
