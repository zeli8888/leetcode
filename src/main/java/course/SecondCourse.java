package course;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : Ze Li
 * @Date : 20/10/2024 14:59
 * @Version : V1.0
 * @Description :
 */
public class SecondCourse {
    private SecondCourse left;
    private SecondCourse right;
    private String val;
    public static void main(String[] args) {
        SecondCourse root = new SecondCourse("A");
        root.left = new SecondCourse("B");
        root.right = new SecondCourse("C");
        root.left.left = new SecondCourse("D");
        root.left.right = new SecondCourse("E");
        root.right.left = new SecondCourse("F");
        root.right.right = new SecondCourse("G");
        System.out.println("Pre-order traversal of binary tree is: ");
        preOrderTraversal(root);
        System.out.println();
        System.out.println("In-order traversal of binary tree is: ");
        inOrderTraversal(root);
        System.out.println();
        System.out.println("Post-order traversal of binary tree is: ");
        postOrderTraversal(root);
    }

    public static void preOrderTraversal(SecondCourse root) {
        System.out.print(root.val);
        if (root.left != null){
            preOrderTraversal(root.left);
        }
        if (root.right != null){
            preOrderTraversal(root.right);
        }
    }

    public static void inOrderTraversal(SecondCourse root) {
        if (root.left != null){
            inOrderTraversal(root.left);
        }
        System.out.print(root.val);
        if (root.right != null){
            inOrderTraversal(root.right);
        }
    }

    public static void postOrderTraversal(SecondCourse root) {
        if (root.left != null){
            postOrderTraversal(root.left);
        }
        if (root.right != null){
            postOrderTraversal(root.right);
        }
        System.out.print(root.val);
    }

    public SecondCourse(SecondCourse left, SecondCourse right, String val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    public SecondCourse(String val) {
        this.val = val;
    }

    public SecondCourse() {
    }


}
