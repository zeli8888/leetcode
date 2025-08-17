package exercise;

import course.TreeNode;

/**
 * @Author : Ze Li
 * @Date : 17/08/2025 14:29
 * @Version : V1.0
 * @Description :
 */
public class MinimumAbsoluteDifferenceInBST530 {
    class Solution {
        int ans = Integer.MAX_VALUE;
        TreeNode pre = null;
        public int getMinimumDifference(TreeNode root) {
            helper(root);
            return ans;
        }
        private void helper(TreeNode node) {
            if (node == null) return;
            helper(node.left);
            if (pre != null) {
                ans = Math.min(ans, Math.abs(node.val - pre.val));
            }
            pre = node;
            helper(node.right);
        }
    }
}
