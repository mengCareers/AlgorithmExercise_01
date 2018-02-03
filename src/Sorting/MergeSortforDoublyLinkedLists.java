/*
 * Thought Process:
 * 
 */
package Sorting;

import Sorting.MergeSortforDoublyLinkedLists.DoublyLinkedList.Node;

/**
 *
 * @author xinrong
 */
public class MergeSortforDoublyLinkedLists {
    static class DoublyLinkedList {
        static Node head;
        static class Node {
            public int val;
            Node next, prev;
            public Node(int val) {
                this.val = val;
                next = null;
                prev = null;
            }
        }
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
            // do with new node
            a.next = mergeUtil(a.next, b);
            a.next.prev = a;
            a.prev = null;
            return a;
        }
        else {
            b.next = mergeUtil(a, b.next);
            b.next.prev = b;
            b.prev = null;
            return b;
        }
    }
    
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.head = new Node(5);
        list.head.next = new Node(20);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(3);
        list.head.next.next.next.next = new Node(30);
        Node ans = new MergeSortforDoublyLinkedLists().mergeSort(DoublyLinkedList.head);
        System.out.println(ans.val);
    }
}
