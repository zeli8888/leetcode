package exercise;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author : Ze Li
 * @Date : 21/01/2025 11:07
 * @Version : V1.0
 * @Description :
 */
public class PerfectSquares279 {
    public int numSquares(int n) {
        int leastSquare = (int) Math.sqrt(n);
        ArrayList<Integer> perfectSquares = new ArrayList<>();
        for (int i = 1; i <= leastSquare; i++){
            perfectSquares.add((int) Math.pow(i, 2));
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp, n+1);
        dp[0] = 0;
        for (int perfectSquare : perfectSquares){
            for (int i = perfectSquare; i <= n; i++){
                dp[i] = Math.min(dp[i], dp[i - perfectSquare] + 1);
            }
        }
        return dp[n];
    }
}
