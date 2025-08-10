package exercise;

import java.util.Stack;

/**
 * @Author : Ze Li
 * @Date : 10/08/2025 19:49
 * @Version : V1.0
 * @Description :
 */
public class SumOfSubarrayMinimums907 {
    class Solution {
        public int sumSubarrayMins(int[] arr) {
            int[] dp = new int[arr.length];
            Stack<int[]> stack = new Stack<>();
            for (int i = 0; i < arr.length; i++) {
                while (!stack.isEmpty() && stack.peek()[0] >= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    dp[i] = (i+1) * arr[i];
                }else {
                    int[] peek = stack.peek();
                    dp[i] = dp[peek[1]] + (i-peek[1]) * arr[i];
                }
                stack.push(new int[] {arr[i], i});
            }
            long ans = 0;
            for (int val : dp) {
                ans += val;
                ans %= 1000000007L;
            }
            return (int) ans;
        }
    }
}
