package LinkedList;


/**
 * 86. Partition List
 * Q: partition it such that
 *      all nodes less than x come BEFORE nodes greater than of equal to x
 *      preserve the orginal relative order of the nodes in each of the two partitions

 * ThoughtProcess: 
 * 1 Remain relative order -> queue
 * 2 Maintain two queues, 1st stores all nodes with val less than x
 *                        2nd stores all the rest nodes
 * 3 Concat two queues
 * 4 Set the tail of 2nd queue a null next
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;
        
        while (head != null) {
            if (head.val < x) {
                cur1.next = head;
                cur1 = head;
            } else {
                cur2.next = head;
                cur2 = head;
            }
            head = head.next;
        }
        cur2.next = null;
        cur1.next = dummy2.next;
        
        return dummy1.next;
    }
}
