/*
Implement a trie with insert, search, and startsWith methods.
 * Thought Process:
word char insert one by one
    e.g. apple
        find a
            
 * 
 */
package Tree;

/**
 *
 * @author xinrong
 */
public class ImplementTrie {

    /** Initialize your data structure here. */
    Node root;
    public ImplementTrie() {
        root = new Node();
    }
    
    class Node {
        boolean isEnd;
        int maxlinks = 26;
        Node[] links = new Node[26];
        
        public boolean contains(char c) {
            return links[c - 'a'] != null;
        }
        
        public void put(char c) {
            links[c - 'a'] = new Node();
        }
        
        public Node get(char c) {
            return links[c - 'a'];
        }
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node ptr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!ptr.contains(c)) {
                ptr.put(c);
            }
            ptr = ptr.get(c);
        }
        ptr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node ptr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!ptr.contains(c)) {
                return false;
            }
            ptr = ptr.get(c);
        }
        if (ptr.isEnd == true)
            return true;
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node ptr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!ptr.contains(c)) {
                return false;
            }
            ptr = ptr.get(c);
        }
        return true;
    } 
}
