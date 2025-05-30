package exercise;

/**
 * @Author : Ze Li
 * @Date : 30/05/2025 20:34
 * @Version : V1.0
 * @Description :
 */
public class TrappingRainWater42 {
    public int trap(int[] height) {
        int[] lHeight = new int[height.length];
        int[] rHeight = new int[height.length];
        int max = height[0];
        for (int i = 1; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
            lHeight[i] = max;
        }
        max = height[height.length-1];
        for (int i = height.length-2; i > 0; i--) {
            if (height[i] > max) {
                max = height[i];
            }
            rHeight[i] = max;
        }
        int ans = 0;
        for (int i = 1; i < height.length-1; i++) {
            int cur = Math.min(lHeight[i], rHeight[i])-height[i];
            if (cur > 0) {
                ans += cur;
            }
        }
        return ans;
    }
}
