package exercise;

import course.TreeNode;

/**
 * @Author : Ze Li
 * @Date : 04/12/2024 22:51
 * @Version : V1.0
 * @Description :
 */
public class BalancedBinaryTree110 {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    public int getHeight(TreeNode root){
        if (root == null) return 0;
        int heightLeft = getHeight(root.left);
        if (heightLeft == -1) return -1;
        int heightRight = getHeight(root.right);
        if (heightRight == -1) return -1;
        if (Math.abs(heightLeft-heightRight)>1) return -1;
        return Math.max(heightLeft, heightRight)+1;
    }
}
