/* 792. Number of Matching Subsequences
 * Thought Process:
 * 
 */
package Hashing;

import java.util.ArrayList;

/**
 *
 * @author xinrong
 */
public class NumberOfMatchSubsequence {

    public static void main(String[] args) {
        String S = "dcaog";
        String[] words = {"dog", "cat", "cop"};
        new NumberOfMatchSubsequence().numMatchingSubseq(S, words);
    }

    /*
    It is fluffy to remove the head of a Strings and update maps accordingly.
    Thus, we use idx in Strings to immitate Mutation => encapsulate Node class
     */
    public int numMatchingSubseq(String S, String[] words) {
        int matchedWords = 0;
        ArrayList<Node>[] hash = new ArrayList[26];
        for (int i = 0; i < hash.length; i++) {
            hash[i] = new ArrayList<Node>();
        }
        for (String word : words) {
            char headCh = word.charAt(0);
            hash[headCh - 'a'].add(new Node(word, 0));
        }
        for (char ch : S.toCharArray()) {
            ArrayList<Node> tmpList = hash[ch - 'a'];
            hash[ch - 'a'] = new ArrayList<>(); 
            // need to assign new list before alter the old FOR we can't update during iteration
            for (Node node : tmpList) {
                node.idx++;
                if (node.idx == node.word.length()) {
                    matchedWords++;
                } else {
                    hash[node.word.charAt(node.idx) - 'a'].add(node);
                }
            }
            tmpList.clear();
        }
        return matchedWords;
    }

    class Node {

        String word;
        int idx;

        public Node(String word, int idx) {
            this.word = word;
            this.idx = idx;
        }
    }
}
