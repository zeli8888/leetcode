package exercise;

/**
 * @Author : Ze Li
 * @Date : 27/07/2025 11:52
 * @Version : V1.0
 * @Description :
 */
public class ReverseLinkedListII92 {
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode root = head;
            int i = 1;
            ListNode leftNode = null;
            while (i != left) {
                i++;
                leftNode = head;
                head = head.next;
            }
            ListNode rightNode = head;

            ListNode lastNode = null;
            while (i != right+1) {
                i++;
                ListNode temp = head.next;
                head.next = lastNode;
                lastNode = head;
                head = temp;
            }

            rightNode.next = head;
            if (left == 1) return lastNode;
            leftNode.next = lastNode;
            return root;
        }
    }
}
