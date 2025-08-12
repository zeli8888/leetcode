package exercise;

import java.util.Iterator;
import java.util.List;

/**
 * @Author : Ze Li
 * @Date : 12/08/2025 20:50
 * @Version : V1.0
 * @Description :
 */
public class FlattenNestedListIterator341 {
    public interface NestedInteger {
         public boolean isInteger();
         public Integer getInteger();
         public List<NestedInteger> getList();
    }

    class Node {
        Node next;
        Integer val;

        public Node(Integer val) {
            this.val = val;
        }
    }

    public class NestedIterator implements Iterator<Integer> {
        Node root;

        public NestedIterator(List<NestedInteger> nestedList) {
            root = new Node(null);
            Node node = root;
            for (NestedInteger nestedInteger : nestedList) {
                node = flattenNestedInteger(node, nestedInteger);
            }
        }

        private Node flattenNestedInteger(Node node, NestedInteger nestedInteger) {
            if (nestedInteger.isInteger()) {
                node.next = new Node(nestedInteger.getInteger());
                return node.next;
            }
            for (NestedInteger nested : nestedInteger.getList()) {
                node = flattenNestedInteger(node, nested);
            }
            return node;
        }

        @Override
        public Integer next() {
            root = root.next;
            return root.val;
        }

        @Override
        public boolean hasNext() {
            return root.next != null;
        }
    }
}
