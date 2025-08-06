package exercise;

/**
 * @Author : Ze Li
 * @Date : 06/08/2025 22:08
 * @Version : V1.0
 * @Description :
 */
public class MinimumCostTreeFromLeafValues1130 {
    public static void main(String[] args) {
        Solution solution = new MinimumCostTreeFromLeafValues1130().new Solution();
        System.out.println(solution.mctFromLeafValues(new int[]{4, 11}));
    }
    class Solution {
        int[][] dp;
        public int mctFromLeafValues(int[] arr) {
            dp = new int[arr.length][arr.length];
            return mctFromLeafValues(arr, 0, arr.length-1);
        }
        public int mctFromLeafValues(int[] arr, int l, int r) {
            if (l >= r) return 0;
            if (dp[l][r] != 0) return dp[l][r];
            int ans = Integer.MAX_VALUE;
            for (int i = l; i < r; i++) {
                int leftVal = mctFromLeafValues(arr, l, i);
                int rightVal = mctFromLeafValues(arr, i+1, r);
                int leftMax = findMax(arr, l, i);
                int rightMax = findMax(arr, i+1, r);
                ans = Math.min(ans, leftMax*rightMax+leftVal+rightVal);
            }
            dp[l][r] = ans;
            return ans;
        }
        private int findMax(int[] arr, int l, int r) {
            int max = arr[l];
            for (int i = l; i <= r; i++) {
                max = Math.max(max, arr[i]);
            }
            return max;
        }
    }
}
