package exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Ze Li
 * @Date : 16/01/2025 19:28
 * @Version : V1.0
 * @Description :
 */
public class Combinations77 {
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        helper(n, k, ans, new ArrayList<Integer>(), 0);
        return ans;
    }

    private void helper(int n, int k, List<List<Integer>> ans, List<Integer> curList, int curVal){
        if (curList.size() == k){
            ans.add(new ArrayList<>(curList));
        }else {
            for (int i = curVal+1; i <= n; i++){
                curList.add(i);
                helper(n, k, ans, curList, i);
                curList.remove(curList.size()-1);
            }
        }
    }
}
