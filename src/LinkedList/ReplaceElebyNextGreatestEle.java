/*
 * Thought Process:
 * 
 */
package LinkedList;

/**
 *
 * @author xinrong
 */
public class ReplaceElebyNextGreatestEle {
    
    public static void main(String[] args) {
        ReplaceElebyNextGreatestEle r = new ReplaceElebyNextGreatestEle();
        Node n1 = new Node((int) (Math.random() * 10));
        Node n2 = new Node((int) (Math.random() * 10));
        Node n3 = new Node((int) (Math.random() * 10));
        Node n4 = new Node((int) (Math.random() * 10));
        Node n5 = new Node((int) (Math.random() * 10));
        Node n6 = new Node((int) (Math.random() * 10));
        Node n7 = new Node((int) (Math.random() * 10));
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        System.out.print("Original: ");
        r.printList(n1);
        
        r.replace(n1);
        
        System.out.print("Final Answer: ");
        r.printList(n1);
    }

    /**
     * To replace element by next greatest element
     * @param head 
     */
    public void replace(Node head) {
        if (head == null || head.next == null)
            return;
        head = reverse(head);
        Node p = head;
        int max = p.val;
        while (p != null) {
            p = p.next;
            if (p != null) {
                int v = p.val;
                p.val = max;
                max = Math.max(max, v);
            }
        }
        System.out.print("Reversed Answer: ");
        new ReplaceElebyNextGreatestEle().printList(head);
        head = reverse(head);
    }

    /**
     * To print the LinkedList
     * @param head 
     */
    void printList(Node head) {
        if (head == null)
            return;
        Node p = head;
        while (p.next != null) {
            System.out.print(p.val + " -> ");
            p = p.next;
        }
        System.out.println(p.val + " -> null");
    }
    
    /**
     * To reverse the LinkedList
     * @param head
     * @return The new head of the reversed LinkedList
     */
    Node reverse(Node head) {
        if (head == null || head.next == null)
            return head;
        Node b = null, m = head, f = m.next;
        while (f != null) {
            m.next = b;
            b = m;
            m = f;
            f = f.next;
        }
        m.next = b;
        head = m;
        System.out.print("Reverse: ");
        new ReplaceElebyNextGreatestEle().printList(head);
       
        return head;       
    }

}
/**
 * User-defined Node class
 * @author xinrong
 */
class Node {
    int val;
    Node next;
    Node(int val) {
        this.val = val;
        next = null;
    }  
}
