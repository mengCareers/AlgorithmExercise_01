/* 353. Design Snake Game
 * Thought Process:
Queue to store food
List to store body
3 cases to consider in move()

1-D bodySet, bodyDeq
move(direction) {
    nx, ny, nh
    3 cases 
        remove tail from Set
        - out of boundaries || eat tail
        add nh,
        - eat food, add tail back to Set
        - just move, remove tail from Deq
}
 * 
 */
package Design;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 *
 * @author xinrong
 */
public class SnakeGame {

    int score = 0;
    int foodi = 0;
    int width;
    int height;
    int[][] food;
    Set<Integer> bodySet;   // 1-D
    Deque<Integer> bodyDeq; // 1-D

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        bodySet = new HashSet<>();
        bodyDeq = new LinkedList<>();

        bodySet.add(0);
        bodyDeq.add(0);
    }

    public int move(String direction) {
        int nx = bodyDeq.peekFirst() / width;
        int ny = bodyDeq.peekFirst() % width;
        switch (direction) {
            case "U":
                nx--;
                break;
            case "D":
                nx++;
                break;
            case "L":
                ny--;
                break;
            default:
                ny++;
                break;
        }
        int nh = nx * width + ny;
        // remove tail from set temporarily
        bodySet.remove(bodyDeq.peekLast());
        // case 1 : out of boundary || eating tail
        if (nx < 0 || ny < 0 || nx >= height || ny >= width || bodySet.contains(nh)) {
            return score = -1;
        }
        bodySet.add(nh);
        bodyDeq.offerFirst(nh);
        // case 2 : eat food, keep tail
        if (foodi < food.length && food[foodi][0] == nx && food[foodi][1] == ny) {
            foodi++;
            bodySet.add(bodyDeq.peekLast());
            return ++score;
        }
        // case 3 : move only, remove tail from bodyDeq
        bodyDeq.pollLast();
        return score;
    }
}
