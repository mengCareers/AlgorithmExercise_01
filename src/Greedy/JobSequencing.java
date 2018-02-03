package Greedy;


import java.util.Arrays;
import java.util.Comparator;

/* every job take single unit of t
 *  Q: input: JobID, Deadline, Profit
maximize total profit if 1 job can be scheduled at a time
 *  Thought Process: 
order by deadline
each deadline choose maximum profit
bf: generate all subsets and trk ma profit
 *  Get:
decreasing order of profit
init res sequence as 1st job
for remaing n - 1jobs:
    if cur fit in cur res seq before deadline, add to res
    else ignore cur
 */

/**
 *
 * @author xinrong
 */
class Job {
    char id;
    int dead;
    int profit;
}
public class JobSequencing {
    int[] jobScheduling(Job[] arr) {
        // in profit decreasing order
        Arrays.sort(arr, new Comparator<Job>(){
            @Override
            public int compare(Job j1, Job j2) {
                return j2.profit - j1.profit; 
            }
        });
        
        int[] res = new int[arr.length];
        boolean[] slot = new boolean[arr.length]; 
        for (int i = 0; i < arr.length; i++) {
            // find a free slot for this job
            for (int j = Math.min(arr[i].dead, arr.length) - 1; j >= 0; j--) {
                if (!slot[j]) {
                    res[j] = i;
                    slot[j] = true;
                    break;
                }
            }
        }
        
        return res;
    }
}
