/*
 * Thought Process:
 * There are two types of Tree Problem Solutions :
   + Simple Recursion
   + Take the advantage of Traversals
 */
package Tree;

import datastructure.TreeNode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author xinrong
 */
public class Tree {

    public TreeNode root;

    public Tree() {
        root = null;
        createTree();
    }

    private void createTree() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        node.left.left.left = new TreeNode(8);
        node.left.left.right = new TreeNode(9);
        node.left.right.right = new TreeNode(10);
        node.right.right.right = new TreeNode(11);
        node.right.right.right = new TreeNode(11);
        root = node;
    }

    public void preorder() {
        preorder(root);
    }

    private void preorder(TreeNode node1) {
        if (node1 != null) {
            System.out.print(node1.val + ", ");
            preorder(node1.left);
            preorder(node1.right);
        }
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(TreeNode node1) {
        if (node1 != null) {
            inorder(node1.left);
            System.out.print(node1.val + ", ");
            inorder(node1.right);
        }
    }

    public void postorder() {
        postorder(root);
    }

    private void postorder(TreeNode node1) {
        if (node1 != null) {
            postorder(node1.left);
            postorder(node1.right);
            System.out.print(node1.val + ", ");
        }
    }

    public int getsz() {
        return getsz(root);
    }

    private int getsz(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // return getsz(node.left) + 1 + getsz(node.right); // inorder in fact
        return 1 + getsz(node.left) + getsz(node.right); // preorder in fact
    }

    public int getheight() {
        return getheight(root);
    }

    private int getheight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // return Math.max(getheight(node.left), getheight(node.right)) + 1; // postorder in fact
        return 1 + Math.max(getheight(node.left), getheight(node.right)); // preorder in fact
    }

    public void printleftnodes() { // preorder in fact
        printleftnodes(root);
    }

    private void printleftnodes(TreeNode node1) {
        if (node1 != null) {
            System.out.print(node1.val + ", ");
            preorder(node1.left);

        }
    }

    public void levelorder() {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                System.out.print(node.val + ", ");
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            } else {
                if (q.isEmpty()) {
                    break;
                }
                System.out.println();
                q.add(null);
            }
        }
    }

    public void ziporder() {
        if (root == null) {
            return;
        }
        boolean print = true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        Stack<TreeNode> stack = new Stack<>(); //
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                if (print) {
                    System.out.print(node.val + ", ");
                } else {
                    stack.push(node);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            } else {
                if (q.isEmpty()) {
                    break;
                }
                print = !print;
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop().val + ", ");
                }
                System.out.println();
                q.add(null);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().val + ", ");
        }
        System.out.println();
    }

    public void printleaves() {
        printleaves(root);
    }

    private void printleaves(TreeNode node1) {
        if (node1 != null) {
            if (node1.left == null && node1.right == null) {
                System.out.print(node1.val + ", ");
            }
            printleaves(node1.left);
            printleaves(node1.right);
        }
    }
    
    public void printleftview() {
        boolean isnewlvl = true;
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                if (isnewlvl) {
                    System.out.print(node.val + ", ");
                    isnewlvl = false;
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            } else {
                if (q.isEmpty()) {
                    break;
                }
                System.out.println();
                q.add(null);
                isnewlvl = true;
            }
        }
    }

    public void printrightview() {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        TreeNode last = null;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                last = node;
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            } else {
                if (q.isEmpty()) {
                    System.out.print(last.val + ", ");
                    break;
                }
                q.add(null);
                System.out.print(last.val + ", ");
                System.out.println();
            }
        }
    }

    class QItem {

        TreeNode node;
        int hd;

        public QItem(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    /**
     * Why do we use QItem?
     * we need to keep track of hd,
     * hd is used in recursion,
     * it is not ref value,
     * so it changed without control, that is, not the same instance every time
     * so we make it 'ref', that is, packed in an object.
     */
    public void printtopview() {
        if (root == null) {
            return;
        }
        int mincol = Integer.MAX_VALUE;
        int maxcol = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, root.val);
        Queue<QItem> q = new LinkedList<QItem>();
        q.add(new QItem(root, 0));

        while (!q.isEmpty()) {
            QItem it = q.poll();
            if (!map.containsKey(it.hd)) {
                map.put(it.hd, it.node.val);
                mincol = Math.min(mincol, it.hd);
                maxcol = Math.max(maxcol, it.hd);
            }
            if (it.node.left != null) {
                q.add(new QItem(it.node.left, it.hd - 1));
            }
            if (it.node.right != null) {
                q.add(new QItem(it.node.right, it.hd + 1));
            }
        }

        for (int i = mincol; i <= maxcol; i++) {
            System.out.print(map.get(i) + ", ");
        }
    }

    public void printKDistLvl(int k) {
        printKDistLvl(root, k);
    }
    
    private void printKDistLvl(TreeNode node, int k) {
        if (node != null) {
            if (k == 1) {
                System.out.print(node.val + " ");
            }
            printKDistLvl(node.left, k - 1);
            printKDistLvl(node.right, k - 1);
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
//        tree.preorder();
//        tree.inorder();
//        tree.postorder();
//        System.out.println("Get size : " + new Tree().getsz());
//        System.out.println("Get height : " + new Tree().getheight());
//        tree.printleftnodes();
//        tree.levelorder();
//        tree.ziporder();
//        tree.printleaves();
//        tree.printleftview();
//        tree.printrightview();
//        tree.printtopview();
        tree.printKDistLvl(3);

    }

}
