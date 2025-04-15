package exercise;

import java.util.Arrays;

/**
 * @Author : Ze Li
 * @Date : 15/04/2025 10:55
 * @Version : V1.0
 * @Description :
 */
public class LongestIncreasingPathInAMatrix329 {
    public int longestIncreasingPath(int[][] matrix) {
        int[] curMaxLength = new int[1];
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int[][] directions = new int[][] {{1,0}, {-1,0}, {0, 1}, {0, -1}};
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] != -1) {continue;}
                helper(matrix, dp, curMaxLength, directions, i, j);
            }
        }
        return curMaxLength[0];
    }

    public int helper(int[][] matrix, int[][] dp, int[] curMaxLength, int[][] directions, int i, int j) {
        int curLength = 1;
        for (int[] direct : directions) {
            int m = i + direct[0];
            int n = j + direct[1];
            if (m >= 0 && m < matrix.length && n >= 0 && n < matrix[0].length && matrix[m][n] < matrix[i][j]) {
                if (dp[m][n] == -1) {
                    dp[m][n] = helper(matrix, dp, curMaxLength, directions, m, n);
                }
                curLength = Math.max(curLength, dp[m][n]+1);
            }
        }
        dp[i][j] = curLength;
        if (curLength > curMaxLength[0]) {
            curMaxLength[0] = curLength;
        }
        return curLength;
    }
}
