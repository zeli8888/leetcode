package exercise;

import course.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Ze Li
 * @Date : 20/08/2025 14:36
 * @Version : V1.0
 * @Description :
 */
public class BinarySearchTreeIterator173 {
    class BSTIterator {
        List<Integer> arr = new ArrayList<Integer>();
        int cur = -1;

        public BSTIterator(TreeNode root) {
            init(root);
        }

        private void init(TreeNode node) {
            if (node == null) return;
            init(node.left);
            arr.add(node.val);
            init(node.right);
        }

        public int next() {
            return arr.get(++cur);
        }

        public boolean hasNext() {
            return cur <= arr.size()-2;
        }
    }
}
