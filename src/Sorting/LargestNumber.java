package Sorting;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* Q: 178. Larget Number
input : arr of num
output: str concatinate by num with the biggest val
 * Thought Process:
- How do we do it BF?
Form all possible strs, and choose the one with biggest val
backtracking
 * Get:
backtracking use list<list> and list mostly, for it will remove the last step, that is backtrack
to avoid dup use of num, we build used[i]
if idx before start can be used, no need to add parameter start
HOWEVER using Integer.valueOf will raise NumberFormatException if input is not within integer range
- Why do we use Integer.valueOf? We need to compare val of two str
- Could we still compare without using Integer.valuOf? Yes, comparator                                                   
HOWEVER will TLE
- Can we elimenate backtrack?
 */
/**
 *
 * @author xinrong
 */
public class LargestNumber {

    public static void main(String[] args) {
//        int[] nums = {31455555, 35555};
//        String ans = new LargestNumber().largestNumber(nums);
//        System.out.println(ans);
        int ans = new LargestNumber().testCompareTo("12", "121");
        System.out.println(ans);
    }

    private int testCompareTo(String a, String b) {
        return a.compareTo(b);
    }

    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        
        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String str1 = s1 + s2;
                String str2 = s2 + s1;
                return str2.compareTo(str1);
                // if return s2.compareTo(s1);
                // "12".compareTo("121") == -1
                // we want 12121 but not 12112
                // so we return str2.compareTo(str1);
            }
        };
        Arrays.sort(strs, cmp);

        if (strs[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }

    public String largestNumberTLE(int[] nums) {

        List<List<String>> pos = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        boolean[] isUsed = new boolean[nums.length];
        formPos(pos, nums, cur, isUsed);

        int sz = pos.size();
        String[] posans = new String[sz];
        int i = 0;
        for (List<String> lst : pos) {
            String tmp = "";
            for (String str : lst) {
                tmp += str;
            }
            posans[i++] = tmp;
        }

        Comparator<String> cp = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                for (int i = 0; i < a.length(); i++) {
                    if (a.charAt(i) < b.charAt(i)) // b is bigger
                    {
                        return -1;
                    } else if (a.charAt(i) > b.charAt(i)) {
                        return 1;
                    }
                }
                return 0;
            }
        };
        Arrays.sort(posans, cp);

        return posans[sz - 1];

    }

    private void formPos(List<List<String>> pos, int[] nums, List<String> cur, boolean[] isUsed) {

        if (cur.size() == nums.length) {
            pos.add(new ArrayList(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i]) {
                continue;
            }

            isUsed[i] = true;
            cur.add(String.valueOf(nums[i]));

            formPos(pos, nums, cur, isUsed);

            isUsed[i] = false;
            cur.remove(cur.size() - 1);
        }

    }

}
