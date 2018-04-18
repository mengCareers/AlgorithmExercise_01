/* 642. Design Search Autocomplete System
There are 3 user-defined classes : Trie, TrieNode, and Pair.
We define PriorityQueue to compare hot degrees among sentences and to poll the Top 3.
Notice : TrieNode 's freq > 0 only if it reaches the end of a word.
 * Thought Process:
 * 
 */
package Design;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author xinrong
 */
public class DesignSearchAutocompleteSystem {

    // # region User-defined Classes
    class Pair {

        String content;
        int freq;

        public Pair(String content, int freq) {
            this.content = content;
            this.freq = freq;
        }
    }

    class TrieNode {

        TrieNode[] children;
        int freq;

        public TrieNode() {
            children = new TrieNode[27];
            freq = 0;
        }
    }

    class Trie {

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public TrieNode insert(String word, int freq) {
            TrieNode ptr = root;
            for (char ch : word.toCharArray()) {
                int id = (ch == ' ') ? 26 : ch - 'a';
                if (ptr.children[id] == null) {
                    ptr.children[id] = new TrieNode();
                }
                ptr = ptr.children[id];
            }
            ptr.freq += freq;
            return ptr;
        }

//        public boolean searchWord(String word) {
//            TrieNode resultNode = searchUtil(word);
//            return (resultNode != null && resultNode.freq > 0);
//        }
//
//        public boolean searchPrefix(String prefix) {
//            TrieNode resultNode = searchUtil(prefix);
//            return resultNode != null;
//        }

        private TrieNode searchUtil(String str) {
            TrieNode ptr = root;
            for (char ch : str.toCharArray()) {
                int id = (ch == ' ' ? 26 : ch - 'a');
                if (ptr.children[id] == null) {
                    return null;
                }
                ptr = ptr.children[id];
            }
            return ptr;
        }

        private void addToPQ(TrieNode tmp, PriorityQueue<Pair> pq, String content) {
            if (tmp == null) {
                return;
            }
            if (tmp.freq > 0) {
                pq.offer(new Pair(content, tmp.freq));
            }
            TrieNode tmpChild = null;
            char ch = 0;
            for (int i = 0; i < tmp.children.length; i++) {
                tmpChild = tmp.children[i];
                if (i != 26) {
                    ch = (char) ('a' + i);
                } else {
                    ch = ' ';
                }
                if (tmpChild != null) {
                    addToPQ(tmpChild, pq, content + ch);
                }
            }
        }
    }

    // # endregion
    
    Trie trie;
    String prefixToNow;

    public DesignSearchAutocompleteSystem(String[] sentences, int[] times) {
        trie = new Trie();
        prefixToNow = "";
        for (int i = 0; i < sentences.length; i++) {
            trie.insert(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        List<String> result = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.freq == b.freq) ? (a.content.compareTo(b.content)) : b.freq - a.freq);
        TrieNode tmpRoot = null;
        if (c == '#') {
            trie.insert(prefixToNow, 1);
            prefixToNow = "";
            return new ArrayList<>();
        }
        prefixToNow += "" + c;
        tmpRoot = trie.searchUtil(prefixToNow);
        trie.addToPQ(tmpRoot, pq, prefixToNow);
        for (int i = 0; i < 3; i++) {
            if (!pq.isEmpty()) {
                Pair pair = pq.poll();
                result.add(pair.content);
            }
        }
        return result;
    }

}
