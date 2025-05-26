package exercise;

/**
 * @Author : Ze Li
 * @Date : 26/05/2025 13:11
 * @Version : V1.0
 * @Description :
 */
public class MiddleOfTheLinkedList876 {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
