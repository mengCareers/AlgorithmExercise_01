package datastructure;


/*
Counter Intuitive,
not store letters in the nodes, instead letter is stored implicitly on each [link]
ArrayBased Trie 
=> To save space, replace array with a Map Map<Character, Node> links
 */
/**
 *
 * @author xinrong
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insertRecursively(String word) {
        insertUtil(root, word, 0);
    }

    private TrieNode insertUtil(TrieNode root, String word, int id) {
        if (root == null) {
            root = new TrieNode();
        }
        if (id == word.length()) {
            root.isEnd = true;
            return root;
        }
        char c = word.charAt(id);
        int index = c - 'a';
        root.arr[index] = insertUtil(root.arr[index], word, id + 1);
        return root;
    }

    public void insertIteratively(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (p.arr[index] == null) {
                TrieNode temp = new TrieNode();
                p.arr[index] = temp;
                p = temp;
            } else {
                p = p.arr[index];
            }
        }
        p.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode p = searchUtil(word);
        if (p == null) {
            return false;
        } else {
            if (p.isEnd) {
                return true;
            }
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode p = searchUtil(prefix);
        if (p == null) {
            return false;
        } else {
            return true;
        }
    }

    private TrieNode searchUtil(String s) {
        TrieNode p = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            if (p.arr[index] != null) {
                p = p.arr[index];
            } else {
                return null;
            }
        }
        if (p == root) {
            return null;
        }
        return p;
    }
}

class TrieNode {

    TrieNode[] arr;
    boolean isEnd;

    public TrieNode() {
        this.arr = new TrieNode[26];
    }
}
