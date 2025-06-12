package exercise;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author : Ze Li
 * @Date : 12/06/2025 13:58
 * @Version : V1.0
 * @Description :
 */
public class CombinationSumIV377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }

//    public int combinationSum4(int[] nums, int target) {
//        int[] dp = new int[target+1];
//        Arrays.fill(dp, -1);
//        dp[0] = 1;
//        return combinationSum4(nums, target, dp);
//    }
//
//    public int combinationSum4(int[] nums, int target, int[] dp) {
//        if (dp[target] != -1) return dp[target];
//        int ans = 0;
//        for (int num : nums) {
//            if (num > target) continue;
//            ans += combinationSum4(nums, target-num, dp);
//        }
//        dp[target] = ans;
//        return ans;
//    }
}
