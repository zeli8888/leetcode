package exercise;
import course.ForthCourse;
/**
 * @Author : Ze Li
 * @Date : 05/12/2024 12:33
 * @Version : V1.0
 * @Description :
 */
public class MinimumDepthOfBinaryTree111 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(new Object[] {1,2,3,4,5,6,7,null,1,null,null,null,2,2});
        System.out.println(root);
        System.out.println( new MinimumDepthOfBinaryTree111().minDepth(root));
    }
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (leftDepth == 0) return rightDepth + 1;
        if (rightDepth == 0) return leftDepth + 1;
        return Math.min(leftDepth, rightDepth) + 1;
    }

}
