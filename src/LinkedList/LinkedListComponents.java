package LinkedList;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 817. Linked List Components
We are given head, the head node of a linked list containing unique integer values.
We are also given the list G, a subset of the values in the linked list.
Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.
Example 1:
Input: 
head: 0->1->2->3
G = [0, 1, 3]
Output: 2
Explanation: 
0 and 1 are connected, so [0, 1] and [3] are the two connected components.
 * Thought Process:
for Node in G, we check if connected in head through UnionFind
 * I think UF is mart, and your solution is clear.
 * However, the non-components defined in this case is also connected actually (as well as in UF)
 * Thus, UF may not be a good way.
 * Get :
 * if node.val is in G, node.next.val is not in G, a component is done
For each node in List {
    if node.val in G 
		if node.next == null || node.next.val not in G 
                         a component is done, num++;
}
 */
/**
 *
 * @author xinrong
 */
public class LinkedListComponents {
    
    public static void main(String[] args) {
        LinkedListComponents inst = new LinkedListComponents();
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        int[] G = {0, 1, 3};
        int res = inst.numComponents(head, G);
        System.out.println(res);
    }
    
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int g : G) {
            set.add(g);
        }
        int num = 0;
        ListNode ptr = head;
        ListNode pre = null;
        while (ptr != null) {
            if (set.contains(ptr.val) && (ptr.next == null || !set.contains(ptr.next.val))) {
                num++;
            }
            ptr = ptr.next;
        }
        return num;
    }
    
    public static class ListNode {
        
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
        }
    }
    
    public int numComponentsWrong(ListNode head, int[] G) {
        UF uf = new UF();
        ListNode ptr = head;
        ListNode pre = null;
        while (ptr.next != null) {
            pre = ptr;
            ptr = ptr.next;
            uf.union(pre.val, ptr.val);
        }
        Set<Integer> parent = new HashSet<>();
        for (int g : G) {
            parent.add(uf.find(g));
        }
        return parent.size();
    }
    
    class UF {
        
        int[] parent;
        
        public UF() {
            parent = new int[10000];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int x) {
            while (parent[x] != x) {
                x = parent[x];
            }
            return x;
        }
        
        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }
    
}
