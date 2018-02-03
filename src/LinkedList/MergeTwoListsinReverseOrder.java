/*
Given two linked lists sorted in increasing order. 
Merge them such a way that the result list is in decreasing order (reverse order).
 * Thought Process:
 * Compare current nodes of both lists and insert smaller at the beginning of result list. 
 */
package LinkedList;

/**
 *
 * @author xinrong
 */
public class MergeTwoListsinReverseOrder {
    Node sortedmerge(Node node1, Node node2) {
        if (node1 == null && node2 == null) return null;
        // the head of result list
        Node res = null;
        while (node1 != null && node2 != null) {
            /*
            list1: node1 -> node1.next -> ..
        listresult:res   -> 
            want : node1 -> res
            */
            if (node1.val <= node2.val) {
                Node tmp = node1.next;
                node1.next = res;
                res = node1;
                node1 = tmp;
            } else {
                Node tmp = node2.next;
                node2.next = res;
                res = node2;
                node2 = tmp;
            }
        }
        while (node1 != null) {
            Node tmp = node1.next;
            node1.next = res;
            res = node1;
            node1 = tmp;
        }
        while (node2 != null) {
            Node tmp = node2.next;
            node2.next = res;
            res = node2;
            node2 = tmp;
        }
        return res;
    }
}
