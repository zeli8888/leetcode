package exercise;

/**
 * @Author : Ze Li
 * @Date : 30/07/2025 14:43
 * @Version : V1.0
 * @Description :
 */
public class PartitionList86 {
    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode leftRoot = new ListNode();
            ListNode left = leftRoot;
            ListNode rightRoot = new ListNode();
            ListNode right = rightRoot;
            while (head != null) {
                if (head.val < x) {
                    left.next = head;
                    left = head;
                }else {
                    right.next = head;
                    right = head;
                }
                head = head.next;
            }
            left.next = rightRoot.next;
            right.next = null;
            return leftRoot.next;
        }
    }
}
