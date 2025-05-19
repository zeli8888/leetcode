package exercise;

import course.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author : Ze Li
 * @Date : 18/05/2025 21:09
 * @Version : V1.0
 * @Description :
 */
public class BinaryTreeRightSideView199 {
    int[] ans = new int[101];
    public List<Integer> rightSideView(TreeNode root) {
        int height = DFS(root, 0)+1;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            result.add(ans[i]);
        }
        return result;
    }

    public int DFS(TreeNode root, int height) {
        if (root == null) return height-1;
        ans[height] = root.val;
        int l = DFS(root.left, height+1);
        int r = DFS(root.right, height+1);
        return Math.max(l,r);
    }
}
