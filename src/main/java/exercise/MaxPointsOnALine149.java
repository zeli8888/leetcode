package exercise;

import java.util.HashMap;

/**
 * @Author : Ze Li
 * @Date : 12/07/2025 16:16
 * @Version : V1.0
 * @Description :
 */
public class MaxPointsOnALine149 {
    class Solution {
        public int maxPoints(int[][] points) {
            if (points.length <= 2) return points.length;
            int ans = 0;
            for (int i = 0; i < points.length-1; i++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                for (int j = i+1; j < points.length; j++) {
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    int cur = 2;
                    for (int k = j+1; k < points.length; k++) {
                        int x3 = points[k][0];
                        int y3 = points[k][1];
                        if ((y3-y2)*(x2-x1) == (y2-y1)*(x3-x2)) {
                            cur++;
                        }
                    }
                    ans = Math.max(cur, ans);
                }
            }
            return ans;
        }
    }
}
