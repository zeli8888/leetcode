package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author : Ze Li
 * @Date : 13/01/2025 16:36
 * @Version : V1.0
 * @Description :
 */
public class BinaryTreePreorderTraversal144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        preorderTraversal(root, ans);
        return ans;
    }

    public void preorderTraversal(TreeNode node, List<Integer> array){
        if (node == null) return;
        array.add(node.val);
        preorderTraversal(node.left, array);
        preorderTraversal(node.right, array);
    }
}
