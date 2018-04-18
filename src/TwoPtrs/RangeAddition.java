/* 370. Range Addition
 * Thought Process:
Initial state:
[ 0, 0, 0, 0, 0 ]

After applying operation [1, 3, 2]:
[ -2, 0, 0, 2, 0 ]
=> [ 0, 2, 2, 2, 0 ]

After applying operation [2, 4, 3]:
[ -2, -3, 0, 2, 3 ]
=> [ 0, 2, 5, 5, 3 ]

After applying operation [0, 2, -2]:
[ -2, -3, -2, 2, 3 ]
=> [ -2, 0, 3, 5, 3 ]

        [1,  3,  2],
        [2,  4,  3],
        [0,  2, -2]
        
        so [i,j] increase 2 is same as [0,j] increase 2 and [0,i-1] increase -2

______________     => At first
      _____
_____/     \__     => Aim
     i     j

      
___  _____/\__     => Strategy : res[i] += res[i + 1];
   \/     j
  i-1
      

 * 
 */
package TwoPtrs;

/**
 *
 * @author xinrong
 */
public class RangeAddition {

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        int si = 0, ei = 0, inc = 0;
        for (int[] update : updates) {
            si = update[0];
            ei = update[1];
            inc = update[2];
            if (si - 1 >= 0) {
                res[si - 1] -= inc;
            }
            res[ei] += inc;
        }
        for (int i = res.length - 1 - 1; i >= 0; i--) {
            res[i] += res[i + 1];
        }
        return res;
    }
}
