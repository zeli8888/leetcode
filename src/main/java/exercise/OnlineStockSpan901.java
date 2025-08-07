package exercise;

import java.util.Stack;

/**
 * @Author : Ze Li
 * @Date : 07/08/2025 13:44
 * @Version : V1.0
 * @Description :
 */
public class OnlineStockSpan901 {
    class StockSpanner {
        Stack<Integer> prices;
        Stack<Integer> nexts;
        public StockSpanner() {
            prices = new Stack<>();
            nexts = new Stack<>();
        }

        public int next(int price) {
            int days = 1;
            while (!prices.isEmpty() && price >= prices.peek()) {
                prices.pop();
                days += nexts.pop();
            }
            prices.push(price);
            nexts.push(days);
            return days;
        }
    }
}
