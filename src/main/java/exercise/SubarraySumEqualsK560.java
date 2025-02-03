package exercise;

import java.util.HashMap;

/**
 * @Author : Ze Li
 * @Date : 03/02/2025 23:39
 * @Version : V1.0
 * @Description :
 */
public class SubarraySumEqualsK560 {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>(); map.put(0,1);
            int sum = 0, validArrs = 0;

            for (int i = 0; i < nums.length; i++){
                sum += nums[i];

                if (map.containsKey(sum-k))
                    validArrs += map.get(sum-k);
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }

            return validArrs;
        }
    }
}
