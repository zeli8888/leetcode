package exercise;

/**
 * @Author : Ze Li
 * @Date : 05/12/2024 23:55
 * @Version : V1.0
 * @Description :
 */
public class LowestCommonAncestorOfABinaryTree236 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(new Object[] {3,5,1,6,2,0,8,null,null,7,4});
        System.out.println(root);
        System.out.println(new LowestCommonAncestorOfABinaryTree236().lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1)));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null){
            return null;
        }

        if(root.equals(p) || root.equals(q)){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left!=null && right!=null){
            return root;
        }

        if(left == null){
            return right;
        }else{
            return left;
        }
    }

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        int[] result = lowestCommonAncestor(root, -1, -1, p.val, q.val, -1);
//        return new TreeNode(result[2]);
//    }
//
//    public int[] lowestCommonAncestor(TreeNode node, int pFound, int qFound, int pValue, int qValue, int result) {
//        if (node == null) return new int[]{-1, -1, 0};
//        int[] leftResult = lowestCommonAncestor(node.left, pFound, qFound, pValue, qValue, result);
//        int[] rightResult = lowestCommonAncestor(node.right, pFound, qFound, pValue, qValue, result);
//        if (leftResult[0] == 1 && leftResult[1] == 1) return leftResult;
//        else if (leftResult[0] == 1) {
//            pFound = 1;
//        } else if (leftResult[1] == 1) {
//            qFound = 1;
//        }
//        if (rightResult[0] == 1 && rightResult[1] == 1) return rightResult;
//        else if (rightResult[0] == 1) {
//            pFound = 1;
//        } else if (rightResult[1] == 1) {
//            qFound = 1;
//        }
//
//        if (node.val == pValue) {
//            pFound = 1;
//        }
//        if (node.val == qValue) {
//            qFound = 1;
//        }
//        return new int[]{pFound, qFound, node.val};
//    }
}
