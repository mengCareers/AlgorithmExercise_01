/* MergeSort preferred to sort linkedlist
head node has to be changed if its data is not the smallest
Get:
The static keyword in Java means that the variable or function 
is shared between all instances of that class 
as it belongs to the type, not the actual objects 
 */
package Sorting;
import RandomAlgo.SelectRandomNodefromSinglyLL;
import Sorting.MergeSortforSinglyLinkedLists.LinkedList.Node;
/**
 *
 * @author xinrong
 */

public class MergeSortforSinglyLinkedLists {
    Node mergeSort(Node h) {
        if (h == null || h.next == null)
            return h;
        // get the middle of list
        Node mid = getMid(h);
        Node midNxt = mid.next;
        // split
        mid.next = null; 
        Node left = mergeSort(h);
        Node right= mergeSort(midNxt);
        // merge
        Node newh = mergeUtil(left, right);
        return newh;
    }
    
    Node mergeUtil(Node a, Node b) {
        Node res = null;
        if (a == null)
            return b;
        if (b == null)
            return a;
        // pick a / b, recur
        if (a.val <= b.val) {
            res = a;
            res.next = mergeUtil(a.next, b);
        }
        else {
            res = b;
            res.next = mergeUtil(a, b.next);
        }
        return res;
    }
    
    Node getMid(Node h) {
        if (h == null || h.next == null) 
            return h;
        Node fptr = h, sptr = h;
        while (fptr.next != null && fptr.next.next != null) { 
            sptr = sptr.next;
            fptr = fptr.next.next;
        }
        return sptr;
    }
    
    static class LinkedList {
        static Node head;
        static class Node {
            public int val;
            Node next;
            public Node(int val) {
                this.val = val;
                next = null;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(5);
        list.head.next = new Node(20);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(3);
        list.head.next.next.next.next = new Node(30);
        Node ans = new MergeSortforSinglyLinkedLists().mergeSort(list.head);
        System.out.println(ans.val);
    }
}
