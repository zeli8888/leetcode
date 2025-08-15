package exercise;

import course.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Ze Li
 * @Date : 15/08/2025 18:15
 * @Version : V1.0
 * @Description :
 */
public class BinaryTreePaths257 {
    class Solution {
        List<String> ans = new ArrayList<>();
        public List<String> binaryTreePaths(TreeNode root) {
            if (root == null) return ans;
            helper(root, "");
            return ans;
        }

        private void helper(TreeNode root, String curString) {
            if (root.left == null && root.right == null) {
                ans.add(curString + root.val);
            }
            if (root.left != null) {helper(root.left, curString + root.val + "->");}
            if (root.right != null) {helper(root.right, curString + root.val + "->");}
        }
    }
}
