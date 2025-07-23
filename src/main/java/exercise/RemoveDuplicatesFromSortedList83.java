package exercise;

/**
 * @Author : Ze Li
 * @Date : 23/07/2025 10:38
 * @Version : V1.0
 * @Description :
 */
public class RemoveDuplicatesFromSortedList83 {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) return null;
            ListNode ans = head;
            ListNode lastNode = head;
            head = head.next;
            while (head != null) {
                if (lastNode.val == head.val) {
                    lastNode.next = head.next;
                }else {
                    lastNode = head;
                }
                head = head.next;
            }
            return ans;
        }
    }
}
