package exercise;

import course.TreeNode;

import java.util.HashMap;

/**
 * @Author : Ze Li
 * @Date : 20/05/2025 17:32
 * @Version : V1.0
 * @Description :
 */
public class PathSumIII437 {
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> sumCount = new HashMap<>();
        sumCount.put(0L, 1);
        return DFS(root, targetSum, 0, sumCount);
    }

    public int DFS(TreeNode root, int targetSum, long curSum, HashMap<Long, Integer> sumCount) {
        if (root == null) return 0;
        curSum += root.val;
        int count = sumCount.getOrDefault(curSum-targetSum, 0);
        sumCount.put(curSum, sumCount.getOrDefault(curSum, 0) + 1);
        count += DFS(root.left, targetSum, curSum, sumCount);
        count += DFS(root.right, targetSum, curSum, sumCount);
        sumCount.put(curSum, sumCount.get(curSum)-1);
        if (sumCount.get(curSum) == 0) {
            sumCount.remove(curSum);
        }
        return count;
    }
}
