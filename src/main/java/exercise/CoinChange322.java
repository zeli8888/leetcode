package exercise;

import java.util.Arrays;

/**
 * @Author : Ze Li
 * @Date : 11/12/2024 20:36
 * @Version : V1.0
 * @Description :
 */
public class CoinChange322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0; // Base case: 0 coins to make amount 0

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != amount+1) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}
