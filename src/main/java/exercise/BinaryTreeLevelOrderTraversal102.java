package exercise;

import course.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Ze Li
 * @Date : 15/05/2025 15:27
 * @Version : V1.0
 * @Description :
 */
public class BinaryTreeLevelOrderTraversal102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelOrder(root, ans, 0);
        return ans;
    }

    public void levelOrder(TreeNode root, List<List<Integer>> ans, int height) {
        if (root == null) return;
        while (ans.size() <= height) {
            ans.add(new ArrayList<>());
        }
        ans.get(height).add(root.val);
        levelOrder(root.left, ans, height+1);
        levelOrder(root.right, ans, height+1);
    }
}
