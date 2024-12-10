package exercise;

/**
 * @Author : Ze Li
 * @Date : 09/12/2024 20:25
 * @Version : V1.0
 * @Description :
 */
public class BestTimeToBuyAndSellStock121 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int prize = prices[0];
        for (int price : prices){
            if (price < prize){
                prize = price;
            }
            profit = Math.max(profit, price - prize);
        }
        return profit;
    }
}
