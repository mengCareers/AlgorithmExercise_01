/*652. Find Duplicate Subtrees
Given a BT, return all duplicate subtrees.
For each kind of duplicate subtrees, you only need to return the root node of any one of them.
Two trees are duplicate if they have the same structure with same node values.
* Get:
=> Tree post-order traversal and serialization
=> Save into Map to check duplicates,
=> Add to result list when appear twice
 */
package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author xinrong
 */
public class FindDuplicateSubtrees {

    Map<String, Integer> map;
    List<TreeNode> result;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        result = new ArrayList<>();
        preorderSerial(root);
        return result;
    }

    private String preorderSerial(TreeNode cur) {
        if (cur == null) {
            return "N";
        }

        String serial = cur.val + "," + preorderSerial(cur.left) + "," + preorderSerial(cur.right);

        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if (map.get(serial) == 2) {
            result.add(cur);
        }

        return serial;
    }
}
