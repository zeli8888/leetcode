package exercise;

/**
 * @Author : Ze Li
 * @Date : 02/02/2025 12:13
 * @Version : V1.0
 * @Description :
 */
public class ContiguousArray525 {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] arr = new int[2 * n + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -2;
        }
        int sum = n, max = 0;
        arr[n] = -1;
        for (int i = 0; i < n; i++) {
            sum = sum + (nums[i] * 2 - 1);
            if (arr[sum] == -2) {
                arr[sum] = i;
            } else {
                max = Math.max(max, i - arr[sum]);
            }
        }
        return max;
    }

//    class Solution {
//        public int findMaxLength(int[] nums) {
//            HashMap<Integer, Integer> map = new HashMap<>();
//            int maxLen = 0;
//            int sum = 0;
//            map.put(0, -1);
//            for (int i = 0; i < nums.length; i++){
//                if (nums[i] == 0) {
//                    sum--;
//                }else{
//                    sum++;
//                }
//                if (map.containsKey(sum)){
//                    maxLen = Math.max(i-map.get(sum), maxLen);
//                }else{
//                    map.put(sum, i);
//                }
//            }
//            return maxLen;
//        }
//    }
}
