/*
 * Thought Process:
 * 
 */
package LinkedList;

/**
 *
 * @author xinrong
 */
public class SingleLinkedList {

    class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public Node head;

    public void makeSingle() {
        head = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
//        Node five = new Node(5);
        head.next = two;
        two.next = three;
        three.next = four;
//        four.next = five;
    }

    public void makeCycle() {
        head = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        Node eight = new Node(8);
        Node nine = new Node(9);
        Node ten = new Node(10);
        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = nine;
        nine.next = ten;
        ten.next = seven;
    }

    /**
     * We are not sure if it is cycle
     *
     * @return
     */
    public Node findCycleStart() {
        if (head == null || head.next == null) {
            return head;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // if cycle
            if (fast == slow) {
                break;
            }
        }
        // if not cycle
        if (fast == null) {
            return null;
        }

        // if 1 2 3 4 5 slow = 3
        // if 1 2 3 4 slow = 3
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public void addDataatHead(int v) {
        Node toadd = new Node(v);
        toadd.next = head;
        head = toadd;
    }

    public void addDataatTail(int v) {
        if (head == null) {
            addDataatHead(v);
        }
        Node toadd = new Node(v);
        Node p = head;
        while (p.next != null) { // saved pre pointer
            p = p.next;
        }
        p.next = toadd;
    }

    public void printList() {
        if (head == null) {
            return;
        }
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " -> ");
            p = p.next;
        }
        System.out.print("NULL"); // don't forget tail NULL
    }

    public int getLen() {
        if (head == null) {
            return 0;
        }
        Node p = head;
        int cnt = 0;
        while (p != null) {
            cnt++;
            p = p.next;
        }
        return cnt;
    }

    public Node findMid() {
        if (head == null || head.next == null) {
            return head;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // if 1 2 3 4 5 slow = 3
        // if 1 2 3 4 slow = 3
        return slow;
    }

    public Node breakListinMiddle() {
        if (head == null || head.next == null) {
            return head;
        }
        Node fast = head;
        Node slow = head;
        Node pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        // if 1 2 3 |4 5 slow = 3 should be 4
        // if 1 2 |3 4 slow = 3
        if (fast != null) {
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;
        return slow;
    }

    public boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        Node snd = breakListinMiddle();
        boolean ispalin = true;
        // we need to put reversed list back before return

        snd = reverse(snd);
        // 1 2 == 5 4 rather than 4 5

        Node fst = head;
        while (snd != null) {
            if (snd.data != fst.data) {
                ispalin = false;
                break;
            }
            fst = fst.next;
            snd = snd.next;
        }
        snd = reverse(snd);
        fst = head;
        while (fst.next != null) {
            fst = fst.next;
        }
        fst.next = snd;
        return ispalin;
    }

    public Node reverse(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
//  in this way, back.next != null
//        Node back = node;
//        Node mid = node.next;
//        Node front = mid.next;
        Node back = null;
        Node mid = node;
        Node front = mid.next;
        while (front != null) {
            mid.next = back;
            back = mid;
            mid = front;
            front = front.next;
        }
        mid.next = back;
        return mid;
    }

    public void reverseList() {
        if (head == null || head.next == null) {
            return;
        }
        Node back = null;
        Node mid = head;
        Node front = head.next;

        while (front != null) {
            mid.next = back;
            back = mid;
            mid = front;
            front = front.next;
        }
        mid.next = back;

        head = mid;
    }


    /**
     * With recursion, we don't need extra space to store result
     * @param h1
     * @param h2
     * @return 
     */
    public Node sortedMergeRecursion(Node h1, Node h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }
        Node r = null;
        if (h1.data < h2.data) {
            r = h1;
            r.next = sortedMergeRecursion(h1.next, h2);
        } else {
            r = h2; // we can return r directly
            r.next = sortedMergeRecursion(h1, h2.next); 
        }

        return r;
    }

    public Node sortedMerge(Node h1, Node h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }
        Node r = new Node(0);
        Node rp = r;
        
        while (h1 != null && h2 != null) {
            if (h1.data < h2.data) {
                r.next = h1;
                h1 = h1.next;
                r = r.next;
            } else {
                r.next = h2;
                h2 = h2.next;
                r = r.next;
            }

        }
        
        if (h1 == null) {
            r.next = h2;
            h2 = h2.next;
            r = r.next;
        }
        if (h2 == null) {
            r.next = h1;
            h1 = h1.next;
            r = r.next;
        }
        return rp.next;
    }

    public void zipMerge() {
        Node snd = breakListinMiddle();
        Node fst = head;
        snd = reverse(snd);
        head = zipMerge(fst, snd, true);
    }
    
    private Node zipMerge(Node fst, Node snd, boolean bswitch) {
        Node r = null;
        if (fst == null)
            return snd;
        if (snd == null)
            return fst;
        if (bswitch) {
            r = fst;
            zipMerge(fst.next, snd, false);
        }
        else {
            r = snd;
            zipMerge(fst, snd.next, true);
        }       
        return r;
    }
    
    public Node findNthFromEnd(int n) {
        if (head == null)
            return null;
        Node front = head;
        Node back = head;
        for (int i = 0; i < n; i++) {
            front = front.next;
            if (front == null)
                return null;
        }
        while (front != null) {
            front = front.next;
            back = back.next;
        }
        return back;
    }
    
    public boolean isCyclic() {
        if (head == null || head.next == null)
            return false;
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        SingleLinkedList sl = new SingleLinkedList();
//        sl.makeSingle();
//        Node m = sl.breakListinMiddle();
//        sl.printList();
//        System.out.println();
//        System.out.println(m.data);
        sl.makeSingle();
        Node h1 = sl.head;
        sl.makeSingle();
        Node h2 = sl.head;
        Node h = sl.sortedMerge(h1, h2);
        
        Node p = h;
        while (p != null) {
            System.out.print(p.data + " -> ");
            p = p.next;
        }
        System.out.print("NULL");
    }

}
