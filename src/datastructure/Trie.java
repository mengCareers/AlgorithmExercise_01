
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    public void insert(String word){
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
    
    /**
     * Returns if the word is in the trie
     * @param word
     * @return 
     */
    public boolean search(String word) {
        TrieNode p = searchNode(word);
        if (p == null) return false;
        else {
            if (p.isEnd) return true;
        }
        return false;
    }
    
    /**
     * Returns if there is any word in the trie that starts with the given prefix
     * @param prefix
     * @return 
     */
    public boolean startsWith(String prefix) {
        TrieNode p = searchNode(prefix);
        if (p == null) return false;
        else return true;
    }
    
    public TrieNode searchNode(String s) {
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
        if (p == root) return null;
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
