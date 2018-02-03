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
    public Node mergeKLists(Node[] lists) {
        if (lists == null || lists.length == 0) return null;
        Node dummyHead = new Node(0);
        Node ptr = dummyHead;
        PriorityQueue<Node> pq = new PriorityQueue<>(lists.length, new Comparator<Node>(){
            @Override
            public int compare(Node a, Node b) {
                return a.val - b.val;
            }
        });
        for (Node node : lists) {
            if (node != null)
                pq.add(node);
        }
        while (!pq.isEmpty()) {
            Node smallest = pq.poll();
            if (smallest != null) {
                ptr.next = smallest;
                ptr = smallest;
                if (smallest.next != null) pq.add(smallest.next);
            } 
        }
        return dummyHead.next;
    }
}
