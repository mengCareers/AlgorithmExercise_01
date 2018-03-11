/*
+ Global vars in distributed system should be locked to maintain consistency, which is more expensive.
So try to avoid global vars.
+ Recursion can be replaced by Iteration + Stack
+ Anything can be solved by inorder traversal
 * Thought Process:
 * 
 */
package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author xinrong
 */
public class BST {

    class Node {

        int data;
        Node left;
        Node right;
        int height;

        private Node() {
        }

        ;

        public Node(int data) {
            this.data = data;
        }

    }

    public static void main(String[] args) {
        BST bst = new BST();
        // bst.inorder();
        // bst.reverseInorder();
        // bst.insertItera(5);
        // bst.insertRecur(0);
        // bst.kthSmallest(2);
        // System.out.println("Within Range # : " + bst.cntNumWithinRange(5, 11));
        // bst.convertToBSTMaintaingStructure();
        int val = bst.findKthLargestNumber(2);
        System.out.println("Kth Largest Number is " + val);

    }

    public Node root;

    public BST() {
        root = null;
        initialize();
    }

    public void initialize() {
        Node node = new Node(8);
        node.left = new Node(3);
        node.left.left = new Node(1);
        node.left.right = new Node(6);
        node.left.right.left = new Node(4);
        node.left.right.right = new Node(7);
        node.right = new Node(10);
        node.right.right = new Node(14);
        node.right.right.left = new Node(13);
        root = node;
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    public void reverseInorder() {
        reverseInorder(root);
    }

    private void reverseInorder(Node node) {
        if (node != null) {                                                     // !!!!!!!!
            reverseInorder(node.right);
            System.out.print(node.data + " ");
            reverseInorder(node.left);
        }

    }

    public void insertItera(int data) {
        if (root == null) {
            return;
        }

        Node parent = null;
        Node cur = root;
        while (cur != null) {
            parent = cur;
            if (data < cur.data) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        if (parent.data < data) {
            parent.right = new Node(data);;
        } else {
            parent.left = new Node(data);;
        }
    }

    public void insertRecur(int data) {
        root = insertRecur(data, root);
    }

    private Node insertRecur(int data, Node node) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) {
            node.left = insertRecur(data, node.left);
        } else {
            node.right = insertRecur(data, node.right);
        }
        return node;
    }

    int cnt;

    public void kthSmallest(int k) {
        cnt = 0;
        kthSmallest(k, root);
    }

    private void kthSmallest(int k, Node node) {
        if (node != null) {
            kthSmallest(k, node.left);
            cnt++;                                                              // !!!!!!!!

            if (cnt == k) {
                System.out.println(node.data);
                return;
            }
            kthSmallest(k, node.right);
        }
    }

    public int cntNumWithinRange(int min, int max) {
        return cntNumWithinRange(min, max, root);
    }

    private int cntNumWithinRange(int min, int max, Node node) {
        if (node == null) {
            return 0;
        }
        if (node.data >= min && node.data <= max) {
            return 1 + cntNumWithinRange(min, max, node.left) + cntNumWithinRange(min, max, node.right);
        } else if (node.data < min) {
            return cntNumWithinRange(min, max, node.right);
        } else {
            return cntNumWithinRange(min, max, node.left);
        }
    }

    int ptrofArr;

    /**
     * Inorder always give sorted in BST So we sort vals of all nodes, and do
     * inorder traversal and reassign values
     */
    public void convertToBSTMaintaingStructure() {
        int cntNodes = getSize();
        int[] arr = new int[cntNodes];
        ptrofArr = 0;
        addValstoArray(root, arr);
        Arrays.sort(arr);
        ptrofArr = 0;
        addValstoTree(root, arr);
    }

    private void addValstoTree(Node node, int[] arr) {
        if (node != null) {
            addValstoTree(node.left, arr);
            node.data = arr[ptrofArr];
            ptrofArr++;
            addValstoTree(node.right, arr);
        }
    }

    private void addValstoArray(Node node, int[] arr) {
        if (node != null) {
            addValstoArray(node.left, arr);
            arr[ptrofArr] = node.data;
            ptrofArr++;
            addValstoArray(node.right, arr);
        }
    }

    public int getSize() {
        return getSize(root);
    }

    private int getSize(Node node) {
        if (node != null) {
            return 1 + getSize(node.left) + getSize(node.right);
        }
        return 0;
    }

    // hw 1 find kth largest number, no global variables cnt, iterative using stack
    public int findKthLargestNumber(int k) {
        int cnt = 0;
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node != null) {
            stack.push(node);
            node = node.right;
        }
        while (!stack.empty()) {
            node = stack.pop();
            cnt++;
            if (cnt == k) {
                return node.data;
            }
            if (node.left != null) {
                node = node.left;
                while (node != null) {
                    stack.push(node);
                    node = node.right;
                }
            }
        }
        return Integer.MIN_VALUE;
    }

    // hw 2 twoSuminTree(int target) {
    public boolean twoSuminBST(int target) {
        List<Integer> lst = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        while (!stack.isEmpty()) {
            node = stack.pop();
            lst.add(node.data);
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        int i = 0, j = lst.size() - 1;
        while (i < j) {
            int sum = lst.get(i) + lst.get(j);
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }
}
