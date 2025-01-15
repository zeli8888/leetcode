package exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Ze Li
 * @Date : 15/01/2025 14:44
 * @Version : V1.0
 * @Description :
 */
public class Permutations46 {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> cur = new ArrayList<>();
        List<List<Integer>> ls = new ArrayList<>();
        helper(nums, ls, cur);
        return ls;
    }

    private void helper(int[] nums, List<List<Integer>> ls, List<Integer> cur){
        if (cur.size() == nums.length){
            ls.add(cur);
            return;
        }
        for (int num : nums){
            if (!cur.contains(num)){
                ArrayList<Integer> newCur = new ArrayList<>(cur);
                newCur.add(num);
                helper(nums, ls, newCur);
            }
        }
    }
}
