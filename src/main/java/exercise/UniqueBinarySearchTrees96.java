package exercise;

import java.util.Arrays;

/**
 * @Author : Ze Li
 * @Date : 29/08/2025 16:24
 * @Version : V1.0
 * @Description :
 */
public class UniqueBinarySearchTrees96 {
    class Solution {
        int[][] dp;
        public int numTrees(int n) {
            dp = new int[n][n];
            return helper(0, n-1);
        }

        private int helper(int start, int end) {
            if (end <= start) return 1;
            if (dp[start][end] != 0) return dp[start][end];
            int numCombine = 0;
            for (int i = start; i <= end; i++) {
                int l = helper(start, i-1);
                int r = helper(i+1, end);
                numCombine += l * r;
            }
            dp[start][end] = numCombine;
            return numCombine;
        }
    }
}
