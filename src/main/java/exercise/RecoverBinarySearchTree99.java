package exercise;

import course.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Ze Li
 * @Date : 30/08/2025 13:24
 * @Version : V1.0
 * @Description :
 */
public class RecoverBinarySearchTree99 {
    class Solution {
        TreeNode prev=null,first=null,second=null;
        void inorder(TreeNode root){
            if(root==null)
                return ;
            inorder(root.left);
            if(prev!=null&&root.val<prev.val){
                if(first==null)
                    first=prev;
                second=root;
            }
            prev=root;
            inorder(root.right);
        }
        public void recoverTree(TreeNode root) {
            if(root==null)
                return ;
            inorder(root);
            int temp=first.val;
            first.val=second.val;
            second.val=temp;
        }
    }
//    class Solution {
//        List<TreeNode> nodes = new ArrayList<>();
//        public void recoverTree(TreeNode root) {
//            inorder(root);
//            List<TreeNode> misOrderNodes = new ArrayList<>(4);
//            for (int i = 0; i < nodes.size()-1; i++) {
//                if (nodes.get(i).val > nodes.get(i+1).val) {
//                    misOrderNodes.add(nodes.get(i));
//                    misOrderNodes.add(nodes.get(i+1));
//                    // 1, 2, 3, 4, 5
//                    // 1, 2, 5, 4, 3 --> 4
//                    // 1, 5, 3, 4, 2 --> 4
//                    // 2, 1, 3, 4, 5 --> 2
//                }
//            }
//            int temp = misOrderNodes.get(0).val;
//            misOrderNodes.get(0).val = misOrderNodes.get(misOrderNodes.size()-1).val;
//            misOrderNodes.get(misOrderNodes.size()-1).val = temp;
//        }
//
//        private void inorder(TreeNode node) {
//            if (node == null) return;
//            inorder(node.left);
//            nodes.add(node);
//            inorder(node.right);
//        }
//    }
}
