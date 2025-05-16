package exercise;

import course.TreeNode;

/**
 * @Author : Ze Li
 * @Date : 16/05/2025 13:10
 * @Version : V1.0
 * @Description :
 */
public class SerializeAndDeserializeBinaryTree297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "#";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    private int index = 0;
    public TreeNode deserialize(String data) {
        String[] s = data.split(",");
        index = 0;
        return buildTree(s);
    }
    private TreeNode buildTree(String[] s){
        if (index >= s.length || s[index].equals("#")) {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s[index++]));
        root.left = buildTree(s);
        root.right = buildTree(s);
        return root;
    }
}
