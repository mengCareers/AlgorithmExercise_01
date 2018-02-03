/*
Design a data structure that supports the following two operations:
void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string 
containing only letters a-z or .. A . means it can represent any one letter.
 */

/**
 *
 * @author xinrong
 */
public class AddandSearchWord {
    TNode root;
    
    public AddandSearchWord() {
        root = new TNode();
    }
    
    public void addWord(String word) {
        TNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (p.arr[index] == null) {
                TNode temp = new TNode();
                p.arr[index] = temp;
                p = temp;
            } else {
                p = p.arr[index];
            }
        }
        p.isLeaf = true;
    }
    
    public boolean search(String word) {
        return dfsSearch(root, word, 0);
    }
    
    public boolean dfsSearch(TNode p, String word, int start) {
        if (p.isLeaf && start == word.length()) return true;
        if (start >= word.length()) return false;
        char c = word.charAt(start);
        if (c == '.') {
            boolean tResult = false;
            for (int j = 0; j < 26; j++) {
                if (p.arr[j] != null) {
                    if (dfsSearch(p.arr[j], word, start + 1)) {
                        tResult = true;
                        break;
                    }
                }
            }
            return tResult;
        } else {
            int index = c - 'a';
            if (p.arr[index] != null) {
                return dfsSearch(p.arr[index], word, start + 1);
            } else {
                return false;
            }
        }
    }
}
class TNode {
    TNode[] arr;
    boolean isLeaf;
    public TNode() {
        arr = new TNode[26];

    }
}
