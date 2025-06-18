package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author : Ze Li
 * @Date : 18/06/2025 15:16
 * @Version : V1.0
 * @Description :
 */
public class FourSum18 {
    public static void main(String[] args) {
        FourSum18 fourSum18 = new FourSum18();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(fourSum18.fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; i++) {
            if (i!=0 && nums[i-1] == nums[i]) continue;
            for (int j = i+1; j < nums.length-2; j++) {
                if (j!=i+1 && nums[j-1] == nums[j]) continue;
                int l = j+1;
                int r = nums.length-1;
                long thisTarget = (long) target - nums[i] - nums[j];
                while (l < r) {
                    long thisSum = (long) nums[l] + nums[r];
                    if (thisSum == thisTarget) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l+1]) l++;
                        while (r > l && nums[r] == nums[r-1]) r--;
                        l++;
                        r--;
                    } else if (thisSum < thisTarget) l++;
                    else r--;
                }
            }
        }
        return ans;
    }
}
