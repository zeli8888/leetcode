package exercise;

import java.util.HashMap;

/**
 * @Author : Ze Li
 * @Date : 17/06/2025 14:08
 * @Version : V1.0
 * @Description :
 */
public class SubarraySumsDivisibleByK974 {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int ans = 0;
        for (int num : nums) {
            sum += num;
            int reminder = sum % k;
            if (reminder < 0) reminder += k;
            ans += map.getOrDefault(reminder, 0);
            map.put(reminder, map.getOrDefault(reminder, 0)+1);
        }
        return ans;
    }
//    public int subarraysDivByK(int[] nums, int k) {
//        int[] sum = new int[nums.length+1];
//        int ans = 0;
//        sum[0] = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum[i+1] = sum[i] + nums[i];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i; j < nums.length; j++) {
//                int subSum = sum[j+1] - sum[i];
//                if (subSum % k == 0) ans++;
//            }
//        }
//        return ans;
//    }
}
