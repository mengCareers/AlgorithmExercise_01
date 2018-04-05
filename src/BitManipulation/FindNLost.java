/*
 * Thought Process:
 * 需要4个32 bit数据，用long存储为了避开int存储可能带来的负数。
   分块查找，每8bit一块，一共需要100/8 + 1=13块
   如果8bit全部是1,则该数据等于2^8-1=255
 */
package BitManipulation;

/**
 *
 * @author xinrong
 */
public class FindNLost {

    public static void findNLosts(int[] arr) {
        int[] ar = new int[100];
        int i = 0;
        for (int a : arr) {
            ar[i++] = a % 100;
        }
        int[] chunks = buildChunks(ar, 100);
        scanChunks(chunks, arr);
    }

    private static int[] buildChunks(int[] arr, int biggest) {
        int[] chunks;
        if (arr.length % 32 == 0) {
            chunks = new int[biggest / 32];
        } else {
            chunks = new int[biggest / 32 + 1];
        }
        for (int i : arr) {
            chunks[i / 32] = chunks[i / 32] | (1 << (i % 32));
        }
        return chunks;
    }

    private static void scanChunks(int[] chunks, int[] arr) {
        for (int i = 0; i < chunks.length; i++) {
            int bit = 1;
            int ti = 0;
            int tans = 0;
            while (chunks[i] != 0) {
                if ((chunks[i] & 1) == 0) {
                    ti = (i * 32) + bit - 1;
                    tans = ti + 100 * (arr[0] / 100);
                    if (tans < arr[0]) {
                        tans = i + 100 * (arr[arr.length - 1] / 100);
                    }
                    System.out.println(tans);
                }
                chunks[i] = chunks[i] >>> 1; // if long, 无符号位，/ 2 即可
                bit++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[97];
        int ai = 0;
        for (int i = 600; i <= 699; i++) {
            if (i == 623) {
                continue;
            }
            if (i == 634) {
                continue;
            }
            if (i == 645) {
                continue;
            }
            if (i == 656) {
                continue;
            }
            arr[ai++] = i;
        }
        findNLosts(arr);
    }
}

//intBit[i] ----- 32
//intbit[0] = 00000000    00000000    0000000        00000000
//intbit[1]
//                                     j
//                                     2  
//intbit[2], i=2: 00000000        00000000        00000000     00000000
//                eightSize=3     eightSize=2     eightSize=1  eightSize=0
