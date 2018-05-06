/* 331. Verify Preorder Serialization of a Binary Tree
One way to serialize a binary tree is to use pre-order traversal. 
When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \

# # # #   # #
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.
 * Thought Process:
WHEN INvalid?
indegree > 1
 * 
 */
package Tree;

/**
 *
 * @author xinrong
 */
public class VerifyPreorderSerializationofBT {

    public boolean isValidSerialization(String preorder) {
        int degree = -1;
        String[] nodes = preorder.split(",");
        for (String node : nodes) {
            degree++;
            if (degree > 0) {
                return false;
            }
            if (!node.equals("#")) {
                degree -= 2;
            }
        }
        return degree == 0;
    }
}
