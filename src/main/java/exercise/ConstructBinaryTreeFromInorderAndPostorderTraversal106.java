package exercise;

import java.util.HashMap;

/**
 * @Author : Ze Li
 * @Date : 14/01/2025 13:47
 * @Version : V1.0
 * @Description :
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, postorder.length-1, map, new int[]{postorder.length-1});
    }

    public TreeNode helper(int[] postorder, int left, int right, HashMap<Integer, Integer> inorderMap, int[] postIndex){
        if (left > right) return null;
        int val = postorder[postIndex[0]];
        postIndex[0]--;
        TreeNode node = new TreeNode(val);
        if (left == right) return node;
        int inorderIndex = inorderMap.get(val);
        node.right = helper(postorder, inorderIndex+1, right, inorderMap, postIndex);
        node.left = helper(postorder, left, inorderIndex-1, inorderMap, postIndex);
        return node;
    }
}
