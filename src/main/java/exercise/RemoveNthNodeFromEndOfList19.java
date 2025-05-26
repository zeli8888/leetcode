package exercise;

/**
 * @Author : Ze Li
 * @Date : 26/05/2025 13:13
 * @Version : V1.0
 * @Description :
 */
public class RemoveNthNodeFromEndOfList19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode slowParent = null;
        for (int i = 0; i < n-1; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slowParent = slow;
            slow = slow.next;
        }
        if (slowParent == null) {
            return head.next;
        } else {
            slowParent.next = slow.next;
            return head;
        }
    }
}
