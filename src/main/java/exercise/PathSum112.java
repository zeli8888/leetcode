package exercise;

import course.TreeNode;

/**
 * @Author : Ze Li
 * @Date : 16/08/2025 13:35
 * @Version : V1.0
 * @Description :
 */
public class PathSum112 {
    class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            return DFS(root, targetSum, 0);
        }

        private boolean DFS(TreeNode node, int targetSum, int curSum) {
            if (node == null) return false;
            curSum += node.val;
            if (node.left == null && node.right == null) return curSum == targetSum;
            boolean leftAns = DFS(node.left, targetSum, curSum);
            return leftAns || DFS(node.right, targetSum, curSum);
        }
    }
}
