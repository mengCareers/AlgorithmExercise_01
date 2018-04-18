
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Thought Process:
word squares : kth row and col read the exact same string
left summetric
 * GET : 
Word squares : kth row and col read the same string.
=> If the length of word in words is n, n words are used to build one possible Word Square.
=> In words[], each word can be first candidate.
=> DFS pattern

e.g. Input ["area","lead","wall","lady","ball"]
if 1st is wall,
   2nd starts with  a  <- area
   3rd starts with  le <- lead
   4nd starts with  lad<- lady
=> i.e., the previous candidates decide prefixes of future words.
=> TRIE data structure
 */
/**
 *
 * @author xinrong
 */
public class WordSquares {

    public static void main(String[] args) {
        String[] words = {"abat", "baba", "atan", "atal"};
        WordSquares inst = new WordSquares();
        List<List<String>> result = inst.wordSquares(words);
        System.out.println(result);
    }

    class Trie {

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public TrieNode insert(String word) {
            TrieNode ptr = root;
            for (char ch : word.toCharArray()) {
                if (ptr.children[ch - 'a'] == null) {
                    ptr.children[ch - 'a'] = new TrieNode();
                }
                ptr.children[ch - 'a'].wordsWithPrefix.add(word);
                ptr = ptr.children[ch - 'a'];
            }
            ptr.isEnd = true;
            return ptr;
        }

        public TrieNode searchUtil(String str) {
            TrieNode ptr = root;
            for (char ch : str.toCharArray()) {
                if (ptr.children[ch - 'a'] == null) {
                    return null;
                }
                ptr = ptr.children[ch - 'a'];
            }
            return ptr;
        }

        public List<String> getWord(String prefix) {
            TrieNode tmpTN = searchUtil(prefix);

            return tmpTN == null ? new ArrayList<>() : tmpTN.wordsWithPrefix;
        }
    }

    class TrieNode {

        TrieNode[] children;
        boolean isEnd;
        List<String> wordsWithPrefix;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
            wordsWithPrefix = new ArrayList<>();
        }

    }

    Trie trie = new Trie();

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> allRes = new ArrayList<>();

        int sz = words[0].length();
        for (String word : words) {
            trie.insert(word);
        }
        for (String word : words) {
            List<String> curRes = new ArrayList<>();
            Set<String> visited = new HashSet<>();
            visited.add(word);
            curRes.add(word);
            dfs(curRes, allRes, words, sz);
        }
        return allRes;
    }

    private void dfs(List<String> curRes, List<List<String>> allRes, String[] words, int sz) {
        if (curRes.size() == sz) {
            allRes.add(new ArrayList<>(curRes));
        } else {
            String prefix = "";
            int idx = curRes.size();
            for (String str : curRes) {
                prefix += str.charAt(idx);
            }
            List<String> strsToAdd = trie.getWord(prefix);
            for (String str : strsToAdd) {
                curRes.add(str);
                dfs(curRes, allRes, words, sz);
                curRes.remove(curRes.size() - 1);
            }
        }
    }
}
