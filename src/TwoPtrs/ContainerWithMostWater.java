/*
  y ^
    |
    |     a2
    |     |  a3          an
    |  a1 |  |     a5    | 
    |  |  |  |  a4 |     |
    |  |  |  |  |  | ..  |
    --------------------------->
   0   1  2  3  4  5 ..  n     x

 * Thought Process:
Tripping Rain Water  => # water for all the bars
This => find any 2 bars holding most water together with a-xis
 * 
 */
package TwoPtrs;

/**
 *
 * @author xinrong
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int s = 0, e = height.length - 1;
        int maxs = 0;
        while (s < e) {

            if (height[s] <= height[e]) {
                maxs = Math.max((e - s) * height[s], maxs);
                s++;
            } else {
                maxs = Math.max((e - s) * height[e], maxs);
                e--;
            }
        }
        return maxs;
    }

//                       .::::.  
//                     .::::::::.  
//                    :::::::::::  
//                 ..:::::::::::'  TLE
//              '::::::::::::'  
//                .::::::::::  
//           '::::::::::::::..  
//                ..::::::::::::.  
//              ``::::::::::::::::  
//               ::::``:::::::::'        .:::.  
//              ::::'   ':::::'       .::::::::.  
//            .::::'      ::::     .:::::::'::::.  
//           .:::'       :::::  .:::::::::' ':::::.  
//          .::'        :::::.:::::::::'      ':::::.  
//         .::'         ::::::::::::::'         ``::::.  
//     ...:::           ::::::::::::'              ``::.  
//    ```` ':.          ':::::::::'                  ::::..  
//                       '.:::::'                    ':'````..
    public static int TLEmaxArea(int[] height) {
        int y = 0, y2 = 0;
        int maxs = 0;
        for (int x = 0; x < height.length - 1; x++) {
            for (int x2 = x + 1; x2 < height.length; x2++) {
                y = height[x];
                y2 = height[x2];
                maxs = Math.max(maxs, Math.min(y, y2) * (x2 - x));
            }
        }
        return maxs;
    }

    public static void main(String[] args) {
        int[] height = {1, 1, 3, 2, 4};
        System.out.println(maxArea(height));
    }
}
