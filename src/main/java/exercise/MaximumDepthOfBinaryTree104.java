package exercise;

import course.TreeNode;

/**
 * @Author : Ze Li
 * @Date : 19/05/2025 10:51
 * @Version : V1.0
 * @Description :
 */
public class MaximumDepthOfBinaryTree104 {
    int ans;
    public int maxDepth(TreeNode root) {
        DFS(root, 0);
        return ans;
    }

    public void DFS(TreeNode root, int height) {
        if (root == null) return;
        height++;
        ans = Math.max(height, ans);
        DFS(root.left, height);
        DFS(root.right, height);
    }
}
