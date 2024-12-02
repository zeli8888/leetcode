package exercise;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : Ze Li
 * @Date : 02/12/2024 15:09
 * @Version : V1.0
 * @Description :
 */
public class SymmetricTree101 {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSame(root.left, root.right);
    }


    private boolean isSame(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        return isSame(left.left, right.right) && isSame(left.right, right.left);

    }

//    public boolean isSymmetric(TreeNode root) {
//        Queue<TreeNode> queueLeft = new LinkedList<>();
//        Queue<TreeNode> queueRight = new LinkedList<>();
//        queueLeft.add(root);
//        queueRight.add(root);
//        while (!queueLeft.isEmpty()){
//            TreeNode nodeLeft = queueLeft.poll();
//            TreeNode nodeRight = queueRight.poll();
//            if (nodeLeft.val != nodeRight.val) return false;
//            if(nodeLeft.left != null && nodeRight.right != null){
//                queueLeft.add(nodeLeft.left);
//                queueRight.add(nodeRight.right);
//            } else if (!(nodeLeft.left == null && nodeRight.right == null)) {
//                return false;
//            }
//
//            if(nodeLeft.right != null && nodeRight.left != null){
//                queueLeft.add(nodeLeft.right);
//                queueRight.add(nodeRight.left);
//            } else if (!(nodeLeft.right == null && nodeRight.left == null)) {
//                return false;
//            }
//        }
//        return true;
//    }
}
