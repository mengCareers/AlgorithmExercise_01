/*
 * Thought Process:
 * 
 */
package Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author xinrong
 */
public class SerializeandDeserializeBT {
    
    public static void main(String[] args) {
        SerializeandDeserializeBT inst = new SerializeandDeserializeBT();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = null;
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        String serialized = inst.serialize(root);
        System.out.println(serialized);
        TreeNode nroot = inst.deserialize(serialized);
        inst.printTree(nroot);
    }
    
    private void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeUtil(root, sb);
        return sb.toString();
    }

    private void serializeUtil(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("N").append(",");
            return;
        }
        sb.append(root.val).append(",");
        serializeUtil(root.left, sb);
        serializeUtil(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(",")));
        return deserializeUtil(q);
    }
    
    private TreeNode deserializeUtil(Queue<String> q) {
        String v = q.remove();
        if (v.equals("N")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(v));
        node.left = deserializeUtil(q);
        node.right = deserializeUtil(q);
        return node;
    }
}
