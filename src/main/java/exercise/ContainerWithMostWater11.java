package exercise;

/**
 * @Author : Ze Li
 * @Date : 10/01/2025 20:27
 * @Version : V1.0
 * @Description :
 */
public class ContainerWithMostWater11 {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while (i != j){
            if (height[i] < height[j]){
                maxArea = Math.max((j-i) * height[i], maxArea);
                i++;
            }else {
                maxArea = Math.max((j-i) * height[j], maxArea);
                j--;
            }
        }
        return maxArea;
    }
}
