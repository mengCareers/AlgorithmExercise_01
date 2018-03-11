/* 315. Count of Smaller Numbers After Self
input : nums
output: List<Integer> such that lst.get(i) = # of smaller elements to the right of nums[i] 
Example:
Given nums = [5, 2, 6, 1]
Return the   [2, 1, 1, 0].
Get : 
construct BST from nums reversely,
e.g. 5, 2, 6, 1
1, 2, 5, 6 add to BST
Thus, when 5, its right 2, 6, 1 already in tree
we need the # of smaller elements, so we store leftsz in BST Node, which is ("left subtree's size")
to avoid duplicate, we also store cursz in BST Node (def = 1)
 * 
 */
package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class CountofSmallerNumbersAfterSelf {

    public static void main(String[] args) {
        int[] nums = {5, 5, 2, 6, 1};
        List<Integer> res = new CountofSmallerNumbersAfterSelf().countSmaller(nums);
        System.out.println(res);
    }

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Node root = new Node(nums[nums.length - 1]); // the first one to be inserted to BST should be the last element in nums
        res.add(0); // the last element in nums has no elements to the right of it
        for (int i = nums.length - 2; i >= 0; i--) { // !!!!!! len - 2
            res.add(0, insertBST(nums[i], root));
        }
        return res;
    }

    private int insertBST(int v, Node root) {
        int cnt = 0;
        Node cur = root;
        while (true) {
            if (cur.val < v) {
                cnt += cur.leftsz + cur.cursz;
                if (cur.right == null) {
                    cur.right = new Node(v);
                    break;
                }
                cur = cur.right;
            } else if (cur.val > v) {
                cur.leftsz++;
                if (cur.left == null) {
                    cur.left = new Node(v);
                    break;
                }
                cur = cur.left;
            } else {
                cur.cursz++;
                cnt += cur.leftsz;
                break;
            }
        }
        return cnt;
    }

    class Node {

        int val;
        Node left;
        Node right;
        int leftsz;
        int cursz;

        public Node(int val) {
            this.val = val;
            cursz = 1;
        }
    }
// TLE

    public List<Integer> countSmallerTLE(int[] nums) {
        List<Integer> counts = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return counts;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int cnt = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    cnt++;
                }
            }
            counts.add(cnt);
        }
        counts.add(0);
        return counts;
    }
}
