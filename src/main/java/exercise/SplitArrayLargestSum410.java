package exercise;

/**
 * @Author : Ze Li
 * @Date : 22/07/2025 12:00
 * @Version : V1.0
 * @Description :
 */
public class SplitArrayLargestSum410 {
    class Solution {
        public int splitArray(int[] nums, int k) {
            int ans = 0;
            int min = nums[0];
            for (int num : nums) {
                ans += num;
                min = Math.max(min, num);
            }
            int max = ans;
            while (min <= max) {
                int mid = min + (max - min) / 2;
                if (isSplittable(nums, k, mid)) {
                    ans = mid;
                    max = mid - 1;
                }else {
                    min = mid + 1;
                }
            }
            return ans;
        }

        private boolean isSplittable(int[] nums, int k, int max) {
            int count = 1;
            int sum = 0;
            for (int num : nums) {
                sum += num;
                if (sum > max) {
                    count++;
                    if (count > k) return false;
                    sum = num;
                }
            }
            return true;
        }
    }
}
