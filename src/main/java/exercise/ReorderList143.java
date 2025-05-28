package exercise;

/**
 * @Author : Ze Li
 * @Date : 28/05/2025 10:04
 * @Version : V1.0
 * @Description :
 */
public class ReorderList143 {
    public static void main(String[] args) {
        ReorderList143 reorderList143 = new ReorderList143();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        reorderList143.reorderList(listNode);
    }
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode preSlow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            preSlow = slow;
            slow = slow.next;
        }
        preSlow.next = null;
        ListNode pre = null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = pre;
            pre = slow;
            slow = temp;
        }
        while (head != null) {
            ListNode headTemp = head.next;
            ListNode preTemp = pre.next;
            head.next = pre;
            pre.next = headTemp == null ? preTemp : headTemp;
            head = headTemp;
            pre = preTemp;
        }

    }
}
