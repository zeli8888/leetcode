package exercise;

/**
 * @Author : Ze Li
 * @Date : 25/05/2025 17:19
 * @Version : V1.0
 * @Description :
 */
public class LinkedListCycle141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
