/* inorder traversal
 * Thought Process:
Serialize no need to do with N or add ',', why ?
When do we use min, max?
 * 
 */
package Tree;

/**
 *
 * @author xinrong
 */
public class SerializeandDeserializeBST {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append((char) (root.val));
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        char[] d = data.toCharArray();
        int[] da = new int[d.length];
        for (int i = 0; i < d.length; i++) {
            da[i] = Integer.valueOf(d[i]);
        }
        return deserializeUtil(da, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    int id = 0;

    private TreeNode deserializeUtil(int[] da, long min, long max) {
        if (id >= da.length || da[id] <= min || da[id] >= max) {
            return null;
        }
        TreeNode root = new TreeNode(da[id++]);
        root.left = deserializeUtil(da, min, root.val);
        root.right = deserializeUtil(da, root.val + 1, max);
        return root;
    }
}
