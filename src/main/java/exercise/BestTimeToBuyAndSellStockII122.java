package exercise;

/**
 * @Author : Ze Li
 * @Date : 17/06/2025 14:04
 * @Version : V1.0
 * @Description :
 */
public class BestTimeToBuyAndSellStockII122 {
        public int maxProfit(int[] prices) {
            int[] dp = new int[prices.length];
            dp[0] = 0;
            for (int i = 1; i < prices.length; i++) {
                dp[i] = prices[i] > prices[i-1] ? dp[i-1] + prices[i] - prices[i-1] : dp[i-1];
            }
            return dp[prices.length-1];
        }
}
