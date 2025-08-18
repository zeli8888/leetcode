package exercise;

import course.TreeNode;

/**
 * @Author : Ze Li
 * @Date : 18/08/2025 12:45
 * @Version : V1.0
 * @Description :
 */
public class SumOfLeftLeaves404 {
    class Solution {
        int sum = 0;
        public int sumOfLeftLeaves(TreeNode root) {
            DFS(root, false);
            return sum;
        }

        private void DFS(TreeNode node, boolean isLeft) {
            if (node == null) return;
            if (node.left == null && node.right == null && isLeft) {
                sum += node.val;
                return;
            }
            DFS(node.right, false);
            DFS(node.left, true);
        }
    }
}
