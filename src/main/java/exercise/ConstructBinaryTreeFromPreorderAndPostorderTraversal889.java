package exercise;

import course.TreeNode;

import java.util.ArrayList;

/**
 * @Author : Ze Li
 * @Date : 28/08/2025 20:42
 * @Version : V1.0
 * @Description :
 */
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal889 {
    class Solution {
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            return helper(preorder, postorder, 0, preorder.length-1, 0, postorder.length-1);
        }

        private TreeNode helper(int[] preorder, int[] postorder, int preStart, int preEnd, int postStart, int postEnd) {
            if (preStart < preEnd) return null;
            TreeNode node = new TreeNode(preorder[preStart]);
            if (preStart == preEnd) return node;
            int index = findIndexInPostorder(postorder, preorder[preStart+1], postStart);
            int size = index - postStart + 1;
            node.left = helper(preorder, postorder, preStart+1, preStart+size, postStart, index);
            node.right = helper(preorder, postorder, preStart+size+1, preEnd, index+1, postEnd-1);
            return node;
        }

        private int findIndexInPostorder(int[] postorder, int target, int start) {
            for(int i = start; i < postorder.length; i++) {
                if (target == postorder[i]) return i;
            }
            return -1;
        }
    }
}
