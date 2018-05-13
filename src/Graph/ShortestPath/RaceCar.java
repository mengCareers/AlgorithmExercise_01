/* 818. Race Car
starts at position 0 and speed + 1 infinitely, (positions can be negative)
drive according to a sequence of instructions A(accelerate) and R(reverse)
if "A", position += speed, speed * 2
if "R", position remains, speed = 1 / -1
input : target
output: length of the shortest sequence of instructions to get there
 * Thought Process:
 * Dijkastra, get single source shortest COST distance IN A WEIGHTED GRAPH 
X single source in this case : target
IT USES PRIORITY QUEUE TO CONTINUALLY SEARCHES THE PATH WITH THE LOWEST COST TO DESTINATION
 * GET :
In fact, this is a shortest path problem, which can be solved by BFS with record of level.

We encapsulate Node class with pos and speed attritutes.Then the start node is (0, 1).
To implement BFS, we need a set to check if we have visited the node before. So we add a method to serialize Node, serial(), which returns a string concatenating pos and speed values.
For a node polled, it has two neighbour nodes. One is formed by 'A', the other one is formed by 'R'. neighbour.pos - target < target is a implicit restriction of the valid answer.
 */
package Graph.ShortestPath;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author xinrong
 */
public class RaceCar {

    class Node {

        int pos;
        int speed;

        public Node(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }

        public String serial() {
            return pos + "," + speed;
        }

    }

    public int racecar(int target) {
        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Node start = new Node(0, 1);
        queue.add(start);
        visited.add(start.serial());

        int level = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                Node cur = queue.poll();
                if (cur.pos == target) {
                    return level;
                }
                Node neighbour1 = new Node(cur.pos + cur.speed, cur.speed * 2);
                if (!visited.contains(neighbour1.serial()) && Math.abs(neighbour1.pos - target) < target) {
                    visited.add(neighbour1.serial());
                    queue.add(neighbour1);
                }
                Node neighbour2 = new Node(cur.pos, cur.speed > 0 ? -1 : 1);
                if (!visited.contains(neighbour2.serial()) && Math.abs(neighbour2.pos - target) < target) {
                    visited.add(neighbour2.serial());
                    queue.add(neighbour2);
                }
            }
            level++;
        }
        return -1;
    }
}
