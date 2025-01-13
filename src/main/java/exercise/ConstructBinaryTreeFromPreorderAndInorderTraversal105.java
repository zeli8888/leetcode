package exercise;

import java.util.HashMap;

/**
 * @Author : Ze Li
 * @Date : 13/01/2025 16:48
 * @Version : V1.0
 * @Description :
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length-1, map, new int[1]);
    }

    public TreeNode buildTree(int[] preorder, int left, int right, HashMap<Integer, Integer> inorderMap, int[] preorderIndex) {
        if (left > right) return null;
        int nodeVal = preorder[preorderIndex[0]];
        TreeNode node = new TreeNode(nodeVal);
        preorderIndex[0]++;
        if (left == right) return node;
        node.left = buildTree(preorder, left, inorderMap.get(nodeVal)-1, inorderMap, preorderIndex);
        node.right = buildTree(preorder, inorderMap.get(nodeVal)+1, right, inorderMap, preorderIndex);
        return node;
    }
}
