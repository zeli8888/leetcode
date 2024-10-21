package exercise;

/**
 @Author : Ze Li
 @Date : 21/10/2024 12:17
 @Version : V1.0
 @Description :
 */

 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
public class ReverseLinkedList206 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ReverseLinkedList206 reverseLinkedList206 = new ReverseLinkedList206();
        ListNode newHead = reverseLinkedList206.reverseList(head);
        while (newHead != null){
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        if (head.next != null){
            ListNode newHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
        }else{
            return head;
        }
    }
}
