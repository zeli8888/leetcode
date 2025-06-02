package exercise;

import java.util.Stack;

/**
 * @Author : Ze Li
 * @Date : 02/06/2025 10:29
 * @Version : V1.0
 * @Description :
 */
public class DailyTemperatures739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int oldDay = stack.pop();
                ans[oldDay] = i - oldDay;
            }
            stack.push(i);
        }
        return ans;
    }
}
