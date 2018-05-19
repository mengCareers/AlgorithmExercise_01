/*
input : ghosts[][], target[]
output: true if it is possible to escape
 * Thought Process:
Manhattan distance
if ghost reach the target before me,
he could wait at the target and definitely eat me,
i am impossible to escape in this case
if it is possible = if it is not impossible

```
My thinking process :
It is required to return true if it is possible to escape.
In other words, we need to return false when it is impossible and for the other scenarios, we return true.
When is it impossible?
If a ghost can reach the target earlier than me, I am impossible to escapse, return false.
For the rest, return true.
Since ghosts and I move based on a strictly horizontal or vertical path, we appy the Manhattan Distance.

Math related:
Red : Manhattan Distance, which equals to Blue, Yello
Green : Straight-line Distance
```
 * 
 */
package Geometry;

/**
 *
 * @author xinrong
 */
public class EscapeTheGhosts {

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int myDist = Math.abs(target[0] - 0) + Math.abs(target[1] - 0);
        int ghostDist = Integer.MAX_VALUE;
        for (int[] ghost : ghosts) {
            ghostDist = Math.abs(target[0] - ghost[0]) + Math.abs(target[1] - ghost[1]);
            if (ghostDist <= myDist) {
                return false;
            }
        }
        return true;
    }
}
