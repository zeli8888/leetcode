package exercise;

/**
 * @Author : Ze Li
 * @Date : 31/07/2025 13:56
 * @Version : V1.0
 * @Description :
 */
public class RemoveDuplicatesFromSortedListII82 {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) return null;
            ListNode root = new ListNode();
            ListNode node = root;
            while (head != null) {
                ListNode lastNode = head;
                head = head.next;
                boolean repeat = false;
                while (head != null && head.val == lastNode.val) {
                    head = head.next;
                    repeat = true;
                }
                if (!repeat) {
                    node.next = lastNode;
                    node = lastNode;
                }
            }
            node.next = null;
            return root.next;
        }
    }
}
