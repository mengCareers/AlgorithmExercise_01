/* 141 Linked List Cycle
 * Thought Process:
 * 
 */
package LinkedList;

/**
 *
 * @author xinrong
 */
public class LinkedListCycle {
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode snd = new ListNode(3);
        head.next = snd;
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next = snd;
        ListNode cstart = new LinkedListCycle().findCycleStart(head);
        System.out.println(cstart.val);
    }

    public ListNode findCycleStart(ListNode head) {
        ListNode meet = hasCycle(head);
        ListNode f = head;
        if (meet != null) {
            System.out.println(meet.val);
            ListNode s = meet;
            while (f != null) {
                f = f.next;
                s = s.next;
                if (f == s) {
                    break;
                }
            }
            return f;
        }
        return null;
    }

    public ListNode hasCycle(ListNode head) {
//        if (head == null || head.next == null)
//            return false;
        ListNode f = head, s = head;
        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
            if (f == s) {
                return f;
            }
        }
        return null;
    }

}
