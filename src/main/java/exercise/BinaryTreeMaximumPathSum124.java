package exercise;

import course.TreeNode;

/**
 * @Author : Ze Li
 * @Date : 19/05/2025 11:11
 * @Version : V1.0
 * @Description :
 */
public class BinaryTreeMaximumPathSum124 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(new Object[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        System.out.println(root);
        BinaryTreeMaximumPathSum124 binaryTreeMaximumPathSum124 = new BinaryTreeMaximumPathSum124();
        System.out.println(binaryTreeMaximumPathSum124.maxPathSum(root));

    }

//    int ans = -1000;
//    public int maxPathSum(TreeNode root) {
//        DFS(root, 0);
//        return ans;
//    }
//
//    public int DFS(TreeNode root, int upSum) {
//        if (root == null) return -1000;
//        upSum = Math.max(0, upSum+root.val);
//        int l = DFS(root.left, upSum);
//        int r = DFS(root.right, upSum);
//        int botSum = Math.max(Math.max(root.val, l+root.val), r+root.val);
//        if (upSum == 0) {
//            ans = Math.max(botSum, ans);
//        }else{
//            ans = Math.max(botSum+upSum-root.val, ans);
//        }
//        ans = Math.max(ans, l+r+root.val);
//        return botSum;
//    }

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    // helper returns the max branch
    // plus current node's value
    int helper(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);

        max = Math.max(max, root.val + left + right);

        return root.val + Math.max(left, right);
    }
}
