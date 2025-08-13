package exercise;

import course.TreeNode;

/**
 * @Author : Ze Li
 * @Date : 13/08/2025 18:48
 * @Version : V1.0
 * @Description :
 */
public class RangeSumOfBST938 {
    class Solution {
        public int rangeSumBST(TreeNode root, int low, int high) {
            if (root == null) return 0;
            int sum = 0;
            if (root.val >= low && root.val <= high) sum += root.val;
            if (root.val >= low) sum += rangeSumBST(root.left, low, high);
            if (root.val <= high) sum += rangeSumBST(root.right, low, high);
            return sum;
        }
    }
}
