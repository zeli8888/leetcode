package exercise;

import java.util.HashMap;

/**
 * @Author : Ze Li
 * @Date : 25/01/2025 17:05
 * @Version : V1.0
 * @Description :
 */
public class TwoSum1 {
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++){
//            for (int j = i+1; j < nums.length; j++){
//                if (nums[i] + nums[j] == target){
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return new int[2];
//    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            if (!map.containsKey(num)){
                map.put(target - num, i);
            }else {
                return new int[]{i, map.get(num)};
            }
        }
        return new int[2];
    }
}
