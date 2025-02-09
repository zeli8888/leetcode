package course;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author : Ze Li
 * @Date : 10/11/2024 20:37
 * @Version : V1.0
 * @Description :
 */

public class ForthCourse {
    public static void main(String[] args) {
//        """
//               1
//              / \
//             2   3
//            / \ / \
//           4  5 6  7
//        """
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);
        TreeNode root = new TreeNode(new Object[] {1,2,3,4,5,6,7});

        System.out.println(root);

        System.out.println("BFS:");
        BFS(root);
        System.out.println();

        System.out.println("DFS:");
        DFS(root);
        System.out.println();
    }

    public static void BFS(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
    public static void DFS(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
}
