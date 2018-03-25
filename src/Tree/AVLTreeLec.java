/*AVL : self-balancing binary search tree
 * Thought Process:
 * 
 */
package Tree;

/**
 *
 * @author xinrong
 */
public class AVLTreeLec {

    Node root;

    Node rotateRight(Node q) {
        Node p = q.left;
        Node b = p.right;
        p.right = q;
        q.left = b;
        q.height = Math.max(getHeight(q.left), getHeight(q.right)) + 1;
        p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
        return p;
    }

    Node rotateLeft(Node p) {
        Node q = p.right;
        Node b = q.left;
        q.left = p;
        p.right = b;
        p.height = Math.max(getHeight(p.left), getHeight(p.right)) + 1;
        q.height = Math.max(getHeight(q.left), getHeight(q.right)) + 1;
        return q;
    }

    int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    Node insert(Node node, int key) {
        if (node == null) {
            return (new Node(key));
        }
        if (key < node.data) {
            node.left = insert(node.left, key);
        } else if (key > node.data) {
            node.right = insert(node.right, key);
        } else {
            return node;
        }
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balance = getBalance(node);
        int lbalance = getBalance(node.left);
        // left left
        if (balance > 1 && lbalance == 1) {
            return rotateRight(node);
        }
        // left right
        if (balance > 1 && lbalance == -1) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        int rbalance = getBalance(node.right);
        // right right
        if (balance < -1 && rbalance == -1) {
            return rotateLeft(node);
        }
        // right left
        if (balance < -1 && rbalance == 1) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    public static void main(String[] args) {
        AVLTreeLec tree = new AVLTreeLec();

        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
         */
        System.out.println("Preorder traversal"
                + " of constructed tree is : ");
        tree.preOrder(tree.root);
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

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
            height = 1;
        }

    }
}
