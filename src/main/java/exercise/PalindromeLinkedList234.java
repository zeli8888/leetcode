package exercise;

/**
 * @Author : Ze Li
 * @Date : 27/05/2025 17:30
 * @Version : V1.0
 * @Description :
 */
public class PalindromeLinkedList234 {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }
        while (pre != null) {
            if (pre.val != head.val) return false;
            pre = pre.next;
            head = head.next;
        }
        return true;
    }
}
