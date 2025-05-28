package exercise;

/**
 * @Author : Ze Li
 * @Date : 28/05/2025 11:46
 * @Version : V1.0
 * @Description :
 */
public class RotateList61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next == null ? head : fast.next;
        }
        if (fast == head) return head;
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode ans = slow.next;
        slow.next = null;
        fast.next = head;
        return ans;
    }
}
