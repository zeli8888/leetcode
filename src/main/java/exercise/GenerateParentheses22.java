package exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Ze Li
 * @Date : 14/01/2025 14:06
 * @Version : V1.0
 * @Description :
 */
public class GenerateParentheses22 {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> ans = new ArrayList<>();
        helper(n, "", 0, 0, ans);
        return ans;
    }

    private void helper(int n, String curString, int sum, int open, ArrayList<String> ans){
        if (curString.length() == n*2) {
            ans.add(curString);
            return;
        }
        if (open < n){helper(n, curString+"(", sum+1, open+1, ans);}
        if (sum > 0){helper(n, curString+")", sum-1, open, ans);}
    }
}
