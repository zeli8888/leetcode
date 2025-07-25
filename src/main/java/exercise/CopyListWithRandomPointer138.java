package exercise;

/**
 * @Author : Ze Li
 * @Date : 25/07/2025 12:12
 * @Version : V1.0
 * @Description :
 */


public class CopyListWithRandomPointer138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) return null;
            Node root = head;
            while (head != null) {
                Node node = new Node(head.val);
                node.next = head.next;
                head.next = node;
                head = node.next;
            }
            head = root;
            while (head != null) {
                head.next.random = head.random == null ? null : head.random.next;
                head = head.next.next;
            }
            head = root;
            Node ans = root.next;
            while (head.next != null) {
                Node temp = head.next;
                head.next = temp.next;
                head = temp;
            }
            return ans;
        }
    }
}
