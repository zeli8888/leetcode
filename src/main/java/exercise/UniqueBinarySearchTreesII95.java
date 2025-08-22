package exercise;

import course.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : Ze Li
 * @Date : 22/08/2025 15:41
 * @Version : V1.0
 * @Description :
 */
public class UniqueBinarySearchTreesII95 {
    class Solution {
        Map<String, List<TreeNode>> mem = new HashMap<>();
        public List<TreeNode> generateTrees(int n) {
            if (n < 1) return new ArrayList<>();
            return helper(1, n);
        }

        private List<TreeNode> helper(int start, int end) {
            ArrayList<TreeNode> ans = new ArrayList<>();
            if (end < start) {
                ans.add(null);
                return ans;
            };
            if (mem.containsKey(start+"-"+end)) return mem.get(start+"-"+end);
            for (int i = start; i <= end; i++) {
                List<TreeNode> left = helper(start, i-1);
                List<TreeNode> right = helper(i+1, end);
                for (TreeNode leftNode : left) {
                    for (TreeNode rightNode : right) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftNode;
                        root.right = rightNode;
                        ans.add(root);
                    }
                }
            }
            mem.put(start+"-"+end, ans);
            return ans;
        }
    }
}
