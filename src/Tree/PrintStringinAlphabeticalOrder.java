/*
input : abc, xy, bcd
output: abc bcd xy
 * Thought Process:
 * represent stringS => Trie
 */
package Tree;

/**
 *
 * @author xinrong
 */
public class PrintStringinAlphabeticalOrder {

    static class TrieNode {

        // boolean isEnd; Instead, we store index of the current word in strs if isEnd true
        int idx;
        TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[26];
            idx = -1;
        }
    }

    static void insert(TrieNode root, String str, int idx) {
        TrieNode ptr = root;
        for (int i = 0; i < str.length(); i++) {
            int cur = str.charAt(i) - 'a';
            if (ptr.children[cur] == null) {
                ptr.children[cur] = new TrieNode();
            }
            ptr = ptr.children[cur];
        }
        ptr.idx = idx;
    }

    static void preorder(TrieNode root, String[] strs) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            TrieNode ptr = root.children[i];
            if (ptr != null) {
                if (ptr.idx != -1) {
                    // print
                    System.out.println(strs[ptr.idx]);
                } else {
                    preorder(ptr, strs);
                }
            }
        }
    }

    static void printInAlphaOrder(String[] strs) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < strs.length; i++) {
            insert(root, strs[i], i);
        }
        preorder(root, strs);
    }

    public static void main(String[] args) {
        String[] strs = {"abc", "xy", "bcd"};
        PrintStringinAlphabeticalOrder.printInAlphaOrder(strs);
    }
}
