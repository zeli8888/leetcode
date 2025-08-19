package exercise;

import course.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Ze Li
 * @Date : 19/08/2025 14:59
 * @Version : V1.0
 * @Description :
 */
public class BinaryTreeInorderTraversal94 {
    class Solution {
        List<Integer> ans = new ArrayList<Integer>();
        public List<Integer> inorderTraversal(TreeNode root) {
            inOrder(root);
            return ans;
        }

        private void inOrder(TreeNode root) {
            if (root == null) return;
            inOrder(root.left);
            ans.add(root.val);
            inOrder(root.right);
        }
    }
}
