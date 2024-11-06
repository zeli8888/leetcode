package exercise;

import java.util.HashMap;

/**
 * @Author : Ze Li
 * @Date : 06/11/2024 14:09
 * @Version : V1.0
 * @Description :
 */
public class MajorityElement169 {
//    public int majorityElement(int[] nums) {
//        int size = nums.length;
//        if (size == 1){
//            return nums[0];
//        }
//        HashMap<Integer, Integer> dictionary = new HashMap<Integer, Integer>();
//        for (int num : nums) {
//            if (dictionary.containsKey(num)) {
//                dictionary.put(num, dictionary.get(num) + 1);
//                if (dictionary.get(num) > size / 2) {
//                    return num;
//                }
//            } else {
//                dictionary.put(num, 1);
//            }
//        }
//        return -1;
//    }
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate)? 1 : -1;
        }
        return candidate;
    }
}
