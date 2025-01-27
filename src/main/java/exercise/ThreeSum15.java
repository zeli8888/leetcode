package exercise;

import java.util.*;

/**
 * @Author : Ze Li
 * @Date : 27/01/2025 10:57
 * @Version : V1.0
 * @Description :
 */
public class ThreeSum15 {
    public static void main(String[] args) {
        ThreeSum15 threeSum15 = new ThreeSum15();
        List<List<Integer>> lists = threeSum15.threeSum(new int[]{0, 0, 0});
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            if (i!=0 && nums[i]==nums[i-1]) {
                continue;
            };
            int left = i+1;
            int right = nums.length-1;
            int targetSum = -nums[i];
            while (left < right){
                int sum = nums[left] + nums[right];
                if (sum == targetSum){
                    ArrayList<Integer> curAns = new ArrayList<>();
                    curAns.add(nums[i]);
                    curAns.add(nums[left]);
                    curAns.add(nums[right]);
                    ans.add(curAns);
                    while (left < right && nums[left]==nums[left+1]) left++;
                    while (left < right && nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                } else if (sum < targetSum) {
                    left++;
                }else{
                    right--;
                }
            }
        }
        return ans;
    }

//    public List<List<Integer>> threeSum(int[] nums) {
//        HashSet<String> ansSet = new HashSet<>();
//        List<List<Integer>> ans = new ArrayList<>();
//        for (int i = 0; i <= nums.length-3; i++){
//            int twoSum = -nums[i];
//            HashSet<Integer> curSet = new HashSet<>();
//            for (int j = i+1; j <= nums.length-1; j++){
//                if (!curSet.contains(nums[j])){
//                    curSet.add(twoSum-nums[j]);
//                }else{
//                    String ansString = Math.min(nums[i], Math.min(nums[j], -nums[i]-nums[j])) + " " + Math.max(nums[i], Math.max(nums[j], -nums[i]-nums[j]));
//                    if (!ansSet.contains(ansString)){
//                        ansSet.add(ansString);
//                        ArrayList<Integer> curAns = new ArrayList<>();
//                        curAns.add(nums[i]);
//                        curAns.add(nums[j]);
//                        curAns.add(-nums[i]-nums[j]);
//                        ans.add(curAns);
//                    }
//                }
//            }
//        }
//        return ans;
//    }
}
