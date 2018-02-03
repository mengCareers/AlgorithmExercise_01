/*
Given two strings, represented as linked lists (every character is a node in linked list). 
Write a function compare() that works similar to strcmp(), 
i.e., it returns 0 if both strings are same, 1 if first linked list is lexicographically greater, and -1 if second string is lexicographically greater.
 * Thought Process:
if same, move on; compare the first different char
it has nothing do with the length at first
 */
package LinkedList;

/**
 *
 * @author xinrong
 */
public class CompareTwoStrings {
    int compare(Node node1, Node node2) {
        if (node1 == null && node2 == null) return 1;
        while (node1 != null && node2 != null && node1.val != node2.val) {
            node1 = node1.next;
            node2 = node2.next;
        }
        if (node1 != null && node2 != null) {
            return node1.val > node2.val ? 1 : -1;
        }
        if (node1 != null && node2 == null) return 1;
        if (node1 == null && node2 != null) return -1;
        return 0;
    }
}
