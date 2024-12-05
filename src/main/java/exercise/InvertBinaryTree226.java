package exercise;

import java.util.LinkedList;
import java.util.Queue;

/**
 @Author : Ze Li
 @Date : 21/10/2024 11:53
 @Version : V1.0
 @Description :
 */
public class InvertBinaryTree226 {
    public TreeNode invertTree(TreeNode root) {
        if (root != null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}
