package exercise;

import course.TreeNode;

import java.util.*;

/**
 * @Author : Ze Li
 * @Date : 20/05/2025 16:28
 * @Version : V1.0
 * @Description :
 */
public class BinaryTreeZigzagLevelOrderTraversal103 {
    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal103 binaryTreeZigzagLevelOrderTraversal103 = new BinaryTreeZigzagLevelOrderTraversal103();
        System.out.println(binaryTreeZigzagLevelOrderTraversal103.zigzagLevelOrder(new TreeNode(new Object[]{1,2,3,4,null,null,5})));
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        int j = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans.add(new LinkedList<>());
            for (int i = 0; i < size; i++) {
                if (j % 2 == 0) {
                    TreeNode node = queue.removeFirst();
                    ans.get(j).add(node.val);
                    if (node.left != null) queue.addLast(node.left);
                    if (node.right != null) queue.addLast(node.right);
                } else {
                    TreeNode node = queue.removeLast();
                    ans.get(j).add(node.val);
                    if (node.right != null)  queue.addFirst(node.right);
                    if (node.left != null) queue.addFirst(node.left);
                }
            }
            j++;
        }
        return ans;
    }
}
