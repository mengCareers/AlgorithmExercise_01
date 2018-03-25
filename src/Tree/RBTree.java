/*
 * Thought Process:
 * 
 */
package Tree;

/**
 *
 * @author xinrong
 */
public class RBTree {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private Node parentOf(Node n) {
        return n == null ? null : n.getParent();
    }

    private Node siblingOf(Node n) {
        return (n == null || n.getParent() == null) ? null
                : (n == n.getParent().getLeft() ? n.getParent().getRight() : n.getParent().getLeft());
    }

    private Node grandparentOf(Node n) {
        return (n == null || n.getParent() == null) ? null : n.getParent().getParent();
    }

    private Node leftOf(Node n) {
        return n == null ? null : n.getLeft();
    }

    private Node rightOf(Node n) {
        return n == null ? null : n.getRight();
    }

    private class Node {

        private int val;
        private boolean color;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int val) {
            this.val = val;
            this.color = BLACK;
            parent = left = right = null;
        }

        private Node getParent() {
            return parent;
        }

        private Node getLeft() {
            return left;
        }

        private void setLeft(Node n) {
            left = n;
        }

        private Node getRight() {
            return right;
        }

        private void setRight(Node n) {
            right = n;
        }

        private int getData() {
            return val;
        }
    }

    public RBTree() {

    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    private boolean isEmpty() {
        return root == null;
    }

    public void add(int data) {
        if (root == null) {
            root = new Node(data);
        }
        Node n = root;
        while (true) {
            if (data < n.getData()) {
                if (n.getLeft() == null) {
                    n.setLeft(new Node(data));
                    adjustAfterInsertion(n.getLeft());
                    break;
                }
                n = n.getLeft();
            } else if (data == n.getData()) {
                return;
            } else {
                if (n.getRight() == null) {
                    n.setRight(new Node(data));
                    adjustAfterInsertion(n.getRight());
                    break;
                }
                n = n.getRight();
            }
        }

    }

    private Node rotateLeft(Node p) {
        Node q = p.right;
        Node b = q.left;
        p.right = b;
        q.left = p;
        q.color = q.left.color;
        q.left.color = RED;
        return q;
    }

    private Node rotateRight(Node q) {
        Node p = q.left;
        Node b = p.right;
        q.left = b;
        p.right = q;
        p.color = p.right.color;
        p.right.color = RED;
        return p;
    }

    private void setColor(Node n, boolean color) {
        n.color = color;
    }

    private void adjustAfterInsertion(Node n) {
        setColor(n, RED);
        if (n != null && n != root && isRed(parentOf(n))) {
            if (isRed(siblingOf(parentOf(n)))) {
                setColor(parentOf(n), BLACK);
                setColor(siblingOf(parentOf(n)), BLACK);
                setColor(grandparentOf(n), RED);
                adjustAfterInsertion(grandparentOf(n));
            } else if (parentOf(n) == leftOf(grandparentOf(n))) {
                if (n == rightOf(parentOf(n))) {
                    rotateLeft(n = parentOf(n)); //
                }
                setColor(parentOf(n), BLACK);
                setColor(grandparentOf(n), RED);
                rotateRight(grandparentOf(n));
            } else if (parentOf(n) == rightOf(grandparentOf(n))) {
                if (n == leftOf(parentOf(n))) {
                    rotateRight(n = parentOf(n));
                }
                setColor(parentOf(n), BLACK);
                setColor(grandparentOf(n), RED);
                rotateLeft(grandparentOf(n));
            }
        }
        setColor(root, BLACK);
    }
}
