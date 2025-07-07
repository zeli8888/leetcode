package exercise;

import java.util.PriorityQueue;

/**
 * @Author : Ze Li
 * @Date : 07/07/2025 17:10
 * @Version : V1.0
 * @Description :
 */
public class MinimumMovesToEqualArrayElements453 {
    class Solution {
        public int minMoves(int[] nums) {
            int low = nums[0];
            for (int num : nums) {
                low = Math.min(num, low);
            }
            int ans = 0;
            for (int num : nums) {
                ans += num-low;
            }
            return ans;
        }
    }
}
