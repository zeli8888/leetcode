package exercise;

import course.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : Ze Li
 * @Date : 02/12/2024 14:41
 * @Version : V1.0
 * @Description :
 */
public class SameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();
        queueP.add(p);
        queueQ.add(q);
        while (!queueP.isEmpty() && !queueQ.isEmpty()){
            TreeNode nodeP = queueP.poll();
            TreeNode nodeQ = queueQ.poll();
            if (nodeP.val != nodeQ.val) return false;
            if (nodeP.left != null && nodeQ.left != null) {
                queueP.add(nodeP.left);
                queueQ.add(nodeQ.left);
            } else if (!(nodeP.left == null && nodeQ.left == null)){
                return false;
            }
            if (nodeP.right != null && nodeQ.right != null) {
                queueP.add(nodeP.right);
                queueQ.add(nodeQ.right);
            } else if (!(nodeP.right == null && nodeQ.right == null)){
                return false;
            }
        }
        return queueP.isEmpty() && queueQ.isEmpty();
    }
}
