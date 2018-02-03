/* e.g.
Sort a large set of floating point num which are in range from 0.0 to 1.0 and are 
uniformly distributed across the range
 * Get: Bucket Sortwhen input is uniformly distributed over a range
create n empty buckets
for every ele do: 
    insert arr[i] into bucket[n * arr[i]]
    sort individual buckets using insertion sort O(1)
    concatenate all sorted buckets
 */
package Sorting;

/**
 *
 * @author xinrong
 */
public class BucketSort {
    public void bucketSort(int[] arr, int maxVal) {
        int[] buckets = new int[maxVal + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = 0;
        }
        for (int i = 0; i < arr.length; i++) { // buckets[val] = freq
            buckets[arr[i]]++;  
        }
        int outPos = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i]; j++) {
                arr[outPos++] = i;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {5, 3, 0, 2, 4, 2};
        new BucketSort().bucketSort(arr, 5);
        for (int a : arr) 
            System.out.print(a + " ");
    }
}
