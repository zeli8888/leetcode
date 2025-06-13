package exercise;

/**
 * @Author : Ze Li
 * @Date : 13/06/2025 13:44
 * @Version : V1.0
 * @Description :
 */
public class CountingBits338 {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        int sub = 1;

        for (int i = 1; i <= n; i++) {
            if (sub * 2 == i) {
                sub = i;
            }

            dp[i] = dp[i - sub] + 1;
        }

        return dp;
    }
//    public int[] countBits(int n) {
//        int[] ans = new int[n + 1];
//        int cur = 0;
//        for (int i = 1; i <= n; i++) {
//            if (cur == 0) {
//                ans[i] = ans[i-1] + 1;
//                cur = 1;
//            }else {
//                ans[i] = ans[i-1];
//                cur = 0;
//            }
//        }
//        return ans;
//    }
}
