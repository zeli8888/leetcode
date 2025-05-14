package exercise;

import course.TreeNode;

/**
 * @Author : Ze Li
 * @Date : 13/05/2025 16:25
 * @Version : V1.0
 * @Description :
 */
public class ValidateBinarySearchTree98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root.left, Long.MIN_VALUE, root.val) && isValidBST(root.right, root.val, Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val > minVal && root.val < maxVal) {
            return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
        }
        return false;
    }
}
