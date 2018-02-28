/*
 * Thought Process:
 * PQ pick the smallest one among lists
   smallest.next into PQ
   until PQ is null
 * set dummyHead for return dummyHead.next
   set ptr for build connections
   PQ<obj> should override Comparator
   we assume that each node in listlist can be null to exclude corner case
   Comparator<Specific> () { @Override ..}
 */
package LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author xinrong
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode lnode : lists) {
            if (lnode != null) {
                pq.add(lnode);
            }
        }

        ListNode head = new ListNode(0);
        ListNode ptr = head;
        while (pq.size() != 0) {
            ListNode pnode = pq.poll();
            ptr.next = pnode;
            ptr = ptr.next;
            if (pnode.next != null) {
                pq.add(pnode.next);
            }
        }
        return head.next;
    }
}
