package exercise;

import course.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author : Ze Li
 * @Date : 19/05/2025 12:27
 * @Version : V1.0
 * @Description :
 */
public class PathSumII113 {
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        DFS(root, targetSum, new LinkedList<Integer>(), 0);
        return ans;
    }

    public void DFS(TreeNode root, int targetSum, LinkedList<Integer> curNodes, int curSum) {
        if (root == null) return;
        curNodes.add(root.val);
        curSum += root.val;
        if (root.left == null && root.right == null && curSum == targetSum) {
            ans.add(List.copyOf(curNodes));
        }
        DFS(root.left, targetSum, curNodes, curSum);
        DFS(root.right, targetSum, curNodes, curSum);
        curNodes.removeLast();
    }
}
