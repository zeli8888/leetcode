package exercise;

import course.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author : Ze Li
 * @Date : 14/05/2025 23:46
 * @Version : V1.0
 * @Description :
 */
public class KthSmallestElementInABST230 {
    int ans = 0;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        findkth(root, k);
        return ans;
    }

    private void findkth(TreeNode root, int k) {
        if (root == null) return;

        // Traverse left subtree
        findkth(root.left, k);

        // Visit node
        count++;
        if (count == k) {
            ans = root.val;
            return;
        }

        // Traverse right subtree
        findkth(root.right, k);
    }
//    public int kthSmallest(TreeNode root, int k) {
//        Stack<Integer> s = new Stack<>();
//        kthSmallest(root, k, s);
//        return s.pop();
//    }
//
//    public void kthSmallest(TreeNode root, int k, Stack<Integer> s) {
//        if (s.size() == k) {
//            return;
//        }
//        if (root.left != null) {
//            kthSmallest(root.left, k, s);
//        }
//        if (s.size() == k) {
//            return;
//        }
//        s.push(root.val);
//        if (s.size() == k) {
//            return;
//        }
//        if (root.right != null) {
//            kthSmallest(root.right, k, s);
//        }
//    }
}
