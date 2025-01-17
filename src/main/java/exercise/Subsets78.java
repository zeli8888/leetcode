package exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Ze Li
 * @Date : 17/01/2025 13:36
 * @Version : V1.0
 * @Description :
 */
public class Subsets78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, new ArrayList<Integer>(), ans, -1);
        return ans;
    }

    private void helper(int[] nums, List<Integer> curList, List<List<Integer>> ans, int lastPos){
        ans.add(new ArrayList<>(curList));
        if (curList.size() != nums.length){
            for (int i = lastPos+1; i < nums.length; i++){
                curList.add(nums[i]);
                helper(nums, curList, ans, i);
                curList.remove(curList.size()-1);
            }
        }
    }
}
