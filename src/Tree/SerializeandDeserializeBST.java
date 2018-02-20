/* inorder traversal
 * Thought Process:
 * 
 */
package Tree;

/**
 *
 * @author xinrong
 */
public class SerializeandDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    // preorder easier to find root
    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append((char)(root.val));
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        char[] d = data.toCharArray();
        int[] da = new int[d.length];
        for (int i = 0; i < d.length; i++) {
            da[i] = Integer.valueOf(d[i]);
        }
        return util(da, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    int id = 0;

    private TreeNode util(int[] da, int min, int max) {
        if (id >= da.length || da[id] < min || da[id] > max) {
            return null;
        }
        TreeNode root = new TreeNode(da[id++]);
        root.left = util(da, min, root.val);
        root.right = util(da, root.val + 1, max);
        return root;
    }
}
