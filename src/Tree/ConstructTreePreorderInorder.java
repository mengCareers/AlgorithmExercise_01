/*
 * Thought Process:
 * 
 */
package Tree;

/**
 *
 * @author xinrong
 */
public class ConstructTreePreorderInorder {

    public static void main(String[] args) {
        String sin = "dbeafc";
        char[] in = sin.toCharArray();
        String spre = "abdecf";
        char[] pre = spre.toCharArray();
        Node r = new ConstructTreePreorderInorder().buildTree(in, pre, 0, sin.length() - 1);
        new ConstructTreePreorderInorder().printInorder(r);
    }

    static class Node {

        char data;
        Node left, right;

        Node(char item) {
            data = item;
            left = right = null;
        }
    }

    int pid = 0;

    Node buildTree(char[] in, char[] pre, int s, int e) {
        if (s > e) {
            return null;
        }
        Node r = new Node(pre[pid++]);
        if (s == e) // without children
        {
            return r;
        }
        int iid = search(in, s, e, r.data);
        r.left = buildTree(in, pre, s, iid - 1);
        r.right = buildTree(in, pre, iid + 1, e);
        return r;
    }

    int search(char[] in, int s, int e, int t) {
        int i;
        for (i = s; i <= e; i++) {
            if (in[i] == t) {
                return i;
            }
        }
        return i;
    }

    /* This funtcion is here just to test buildTree() */
    void printInorder(Node node) {
        if (node == null) {
            return;
        }

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.data + " ");

        /* now recur on right child */
        printInorder(node.right);
    }
}
