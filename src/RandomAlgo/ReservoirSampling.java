/* Reservoir Sampling
randomly choosing k samples from n items (n is too large to fit into main memory or unknown)
 * Thought Process:
Get:
BF:
select an item from stream, if not previously selected, put it in reservoir[]
to chk if previously selected, need to search the item in reservoir[]
O(n):
copy first k items of stream[] to reservoir[0..k-1]
consider all items from (k + 1)th to nth item
    generate rand num j from 0 to i
    if j is within 0 to k - 1, replace reservoir[j] with arr[i]
 * 
 */
package RandomAlgo;

import java.util.Random;

/**
 *
 * @author xinrong
 */
public class ReservoirSampling {
    public int[] selectKItems(int[] stream, int k) {
        int[] reservoir = new int[k];
        int i = 0;
        for (;i < k; i++)
            reservoir[i] = stream[i];
        Random rand = new Random();
        
        while (i < stream.length) {
            int j = rand.nextInt(i + 1);
            if (j < k)
                reservoir[j] = stream[i];
            i++;
        }
        return reservoir;
    }
}
