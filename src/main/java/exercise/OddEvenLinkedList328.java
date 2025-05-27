package exercise;

/**
 * @Author : Ze Li
 * @Date : 27/05/2025 15:39
 * @Version : V1.0
 * @Description :
 */
public class OddEvenLinkedList328 {
    public static void main(String[] args) {
        OddEvenLinkedList328 oddEvenLinkedList328 = new OddEvenLinkedList328();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        oddEvenLinkedList328.oddEvenList(root);
    }
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode rootEven = even;
        while (even != null && even.next != null) {
            ListNode nextEven = even.next.next;
            ListNode nextOdd = odd.next.next;
            even.next = nextEven;
            even = nextEven;
            odd.next = nextOdd;
            odd = nextOdd;
        }
        odd.next = rootEven;
        return head;
    }
}
