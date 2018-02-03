/* 
 * Thought Process:
 * Get:
cnt # of nodes by traversing
generate a rand from 0 to N - i
select the ith node only if rand == 0
 */
package RandomAlgo;


import RandomAlgo.LList.Node;
import java.util.Random;
/**
 *
 * @author xinrong
 */

class LList {
    static Node head;    
    static class Node {
        int data;
        Node next;
        Node (int d) {
            data = d;
            next = null;
        }
    }
    public static void main(String[] args) {
        LList list = new LList();
        list.head = new Node(5);
        list.head.next = new Node(20);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(3);
        list.head.next.next.next.next = new Node(30);
        int ans = new SelectRandomNodefromSinglyLL().getRandomNode(list.head);
        System.out.println(ans);
    }
}
public class SelectRandomNodefromSinglyLL {
    public int getRandomNode(Node node) {
        if (node == null)
            return Integer.min(0, 0);
        int res = node.data;
        Node cur = node;
        int i;
        Random rand = new Random();
        for (i = 1; cur != null; i++) { // 2th node
            if (rand.nextInt(i + 1) == 0) // fixed # between. probability 1/i
                res = cur.data;
            cur = cur.next;
        }
        return res;
    }
}
