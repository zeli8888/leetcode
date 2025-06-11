package exercise;

/**
 * @Author : Ze Li
 * @Date : 11/06/2025 12:41
 * @Version : V1.0
 * @Description :
 */
public class MaximalSquare221 {
    public int maximalSquare(char[][] matrix) {
        int ans = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') continue;
                int curMin = Integer.MAX_VALUE;
                for (int[] direction : directions) {
                    int k = i + direction[0];
                    int l = j + direction[1];
                    if (k < 0 || k >= m || l < 0 || l >= n) continue;
                    curMin = Math.min(dp[k][l], curMin);
                }
                dp[i][j] = curMin+1;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans * ans;
    }
}
