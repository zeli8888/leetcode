package exercise;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author : Ze Li
 * @Date : 18/06/2025 14:57
 * @Version : V1.0
 * @Description :
 */
public class FindAllDuplicatesInAnArray442 {
    public List<Integer> findDuplicates(int[] nums) {
        LinkedList<Integer> ans = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            if (nums[val-1] < 0) ans.add(val);
            else nums[val-1] *= -1;
        }
        return ans;
    }
}
