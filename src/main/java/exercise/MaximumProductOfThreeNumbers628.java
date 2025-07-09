package exercise;

import java.util.Arrays;

/**
 * @Author : Ze Li
 * @Date : 09/07/2025 21:55
 * @Version : V1.0
 * @Description :
 */
public class MaximumProductOfThreeNumbers628 {
    class Solution {
        public int maximumProduct(int[] nums) {
            Arrays.sort(nums);
            return Math.max(nums[0]*nums[1]*nums[nums.length-1], nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3]);
        }
    }
}
