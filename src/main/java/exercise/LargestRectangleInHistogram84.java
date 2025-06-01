package exercise;

import java.util.Stack;

/**
 * @Author : Ze Li
 * @Date : 01/06/2025 15:07
 * @Version : V1.0
 * @Description :
 */
public class LargestRectangleInHistogram84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int l = stack.isEmpty() ? -1 : stack.peek();
                ans = Math.max(ans, (i-l-1) * height);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            int l = stack.isEmpty() ? -1 : stack.peek();
            ans = Math.max(ans, (heights.length-l-1) * height);
        }
        return ans;
    }
}
