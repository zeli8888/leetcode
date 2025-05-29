package exercise;

/**
 * @Author : Ze Li
 * @Date : 28/05/2025 11:46
 * @Version : V1.0
 * @Description :
 */
public class RotateList61 {
    public ListNode rotateRight(ListNode head, int k) {
        // Step 1: Handle edge cases 🛡️
        if (head == null || head.next == null || k == 0) {
            return head; // Nothing to rotate, return as is
        }

        // Step 2: Find the length of the list and the tail node 📏
        ListNode tail = head;
        int length = 1; // Start at 1 because we already have the head
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 3: Form a circular linked list 🔄
        tail.next = head; // Point the tail to the head, making it circular!

        // Step 4: Optimize k, handle large rotations 🧮
        k = k % length; // k could be larger than the list length
        if (k == 0) {
            tail.next = null; // If k is a multiple of length, no change
            return head;
        }

        // Step 5: Find the new tail 🎯
        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next; // Move to the correct spot
        }

        // Step 6: Break the circular list and form the new one ✂️
        ListNode newHead = newTail.next; // The node after newTail becomes the new head
        newTail.next = null; // Break the link to form the new tail
        return newHead;
    }

//    public ListNode rotateRight(ListNode head, int k) {
//        if (head == null || head.next == null) return head;
//        ListNode fast = head;
//        for (int i = 0; i < k; i++) {
//            fast = fast.next == null ? head : fast.next;
//        }
//        if (fast == head) return head;
//        ListNode slow = head;
//        while (fast.next != null) {
//            fast = fast.next;
//            slow = slow.next;
//        }
//        ListNode ans = slow.next;
//        slow.next = null;
//        fast.next = head;
//        return ans;
//    }
}
