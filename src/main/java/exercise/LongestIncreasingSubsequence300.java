package exercise;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author : Ze Li
 * @Date : 10/12/2024 14:56
 * @Version : V1.0
 * @Description :
 */
public class LongestIncreasingSubsequence300 {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int num : nums){
            int largerPos = binarySearch(answer, num);
            if (largerPos == answer.size()){
                answer.add(num);
            }else{
                answer.set(largerPos, num);
            }
        }
        return answer.size();
    }
    public int binarySearch(ArrayList<Integer> answer, int target){
        int low = 0;
        int high = answer.size()-1;
        while (low < high){
            int mid = (low+high)/2;
            int midValue = answer.get(mid);
            if (midValue > target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
//    public int lengthOfLIS(int[] nums) {
//        int n = nums.length;
//        if (n == 0) return 0;
//
//        int[] dp = new int[n];
//        Arrays.fill(dp, 1); // Minimum LIS for each element is 1.
//
//        int maxLen = 1; // To track the maximum LIS length.
//
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if (nums[j] < nums[i]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//            maxLen = Math.max(maxLen, dp[i]); // Update the global maximum.
//        }
//
//        return maxLen;
//    }
}
