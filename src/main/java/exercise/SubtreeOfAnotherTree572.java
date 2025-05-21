package exercise;

import course.TreeNode;

/**
 * @Author : Ze Li
 * @Date : 21/05/2025 14:06
 * @Version : V1.0
 * @Description :
 */
public class SubtreeOfAnotherTree572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return search(root, subRoot);
    }

    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val != subRoot.val) return false;
        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }

    private boolean search(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;
        return search(root.left, subRoot) || search(root.right, subRoot);
    }
}
