/* 659.Split Array into Consecutive Subsequences
input : nums[], sorted ascending with duplicates
output: true if can split them into several subsequences with at least 3 consecutive integers
 * Get :

Created at: a few seconds ago

meng.careers
meng.careers
 13
For a coming num in nums[], there are 3 cases. We take [1, 2, 3, 3, 4, 5, 7] as an example to illustrate these 3 cases.

Case 1 : num == pq.peek().tail, we offer a new sequence ( tail : num, length : 1 ) to pq.
=> We assume sequence [1, 2, 3] represented as ( tail : 3, length : 3 ) is in heap already.
num = 3 comes next, it satisfies case 1, so we offer a new sequence ( tail : 3, length : 1 ) to pq.
Case 2 : num == pq.peek().tail + 1, we append it to pq.peek() sequence.
=> num = 4 coms next, it satisfies case 2, so we append it to pq.peek(), i.e., update its tail and length to ( tail : 4, length : 2 )
Case 3 : num > p1.peek().tail + 1, we either append it to the proper pq.peek() sequence, or offer a new sequence ( tail : num, length : 1 ) to pq.
=> We assume sequence [1, 2, 3] [3, 4, 5] is in heap already.

num = 7 comes next, it satisfies case 3, we keep popping from the pq and try to append num to the sequence with the tail such that num == pq.peek().tail + 1. If we can't find such sequence in pq, i.e., the pq is empty, we offer a new sequence ( tail : 7, length : 1 ) to pq.
All sequences are sorted by tail ( last element in sequence ) increasingly, if tail equals, sorted by length ( length of sequence) increasingly.
During the process, for all sequences popped from pq, their length should > 3.
In the end, for all sequences remained in pq, their length should > 3.
 * 
 */
package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author xinrong
 */
public class SplitArrayintoConsecutiveSubsequences {

    public boolean isPossible(int[] nums) {

        PriorityQueue<Sequence> pq = new PriorityQueue<>(new Comparator<Sequence>() {
            @Override
            public int compare(Sequence o1, Sequence o2) {
                if (o1.tail == o2.tail) {
                    return o1.length - o2.length;
                }
                return o1.tail - o2.tail;
            }
        });

        for (int num : nums) {
            if (!pq.isEmpty() && num == pq.peek().tail) {
                pq.offer(new Sequence(num, 1));
            } else {
                while (!pq.isEmpty() && num > pq.peek().tail + 1) {
                    if (pq.poll().length < 3) {
                        return false;
                    }
                }
                if (pq.isEmpty()) {
                    pq.offer(new Sequence(num, 1));
                } else {
                    Sequence seq = pq.poll();
                    seq.tail = num;
                    seq.length++;
                    pq.offer(seq);
                }
            }
        }
        while (!pq.isEmpty()) {
            if (pq.poll().length < 3) {
                return false;
            }
        }

        return true;

    }

    class Sequence {

        int tail;
        int length;

        public Sequence(int tail, int length) {
            this.tail = tail;
            this.length = length;
        }

    }
}
