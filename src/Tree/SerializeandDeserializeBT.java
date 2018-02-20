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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeUtil(root, sb);
        return sb.toString();
    }

    // preorder
    private void serializeUtil(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("N");
            return;
        }
        sb.append(root.val).append(",");
        serializeUtil(root.left, sb);
        serializeUtil(root.right, sb);
    }

    // Decodes your encoded data to tree.
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
