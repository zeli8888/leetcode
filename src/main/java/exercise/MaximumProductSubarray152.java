package exercise;

/**
 * @Author : Ze Li
 * @Date : 18/01/2025 15:22
 * @Version : V1.0
 * @Description :
 */
public class MaximumProductSubarray152 {
    public static void main(String[] args) {
        MaximumProductSubarray152 maximumProductSubarray152 = new MaximumProductSubarray152();
        System.out.println(maximumProductSubarray152.maxProduct(new int[]{-1, -2, -9, -6}));
    }
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int maxEnding = nums[0];
        int minEnding = nums[0];

        for (int i = 1; i < nums.length; i++){
            int num = nums[i];
            int newMaxEnding = maxEnding * num;
            int newMinEnding = minEnding * num;
            maxEnding = Math.max(Math.max(newMaxEnding, num), newMinEnding);
            minEnding = Math.min(Math.min(newMaxEnding, num), newMinEnding);
            maxProduct = Math.max(maxProduct, maxEnding);
        }

        return maxProduct;
    }
}
