package exercise;

/**
 * @Author : Ze Li
 * @Date : 26/11/2024 21:19
 * @Version : V1.0
 * @Description :
 */


public class SortList148 {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    // quick sort
    private ListNode sortList(ListNode start, ListNode end) {
        if (start == null || start == end || start.next == end) {
            return start;
        }
        ListNode head = start, tail = start, node = start.next;
        boolean sorted = true;
        while (node != end) {
            ListNode next = node.next;
            // pivot = start.val
            if (node.val < start.val) {
                if (node.val > head.val) {
                    sorted = false;
                }
                node.next = head;
                head = node;
                tail.next = next;
            } else {
                if (node.val < tail.val) {
                    sorted = false;
                }
                tail = node;
            }
            node = next;
        }
        if (sorted) {
            return head;
        }
        ListNode start1 = sortList(head, start);
        ListNode start2 = sortList(start.next, end);
        start.next = start2;
        return start1;
    }

// merge sort
//    public ListNode sortList(ListNode head) {
//        if (head == null || head.next == null){
//            return head;
//        }
//        ListNode slowNode = head;
//        ListNode quickNode = head.next;
//        while (quickNode != null && quickNode.next != null){
//            slowNode = slowNode.next;
//            quickNode = quickNode.next.next;
//        }
//        ListNode middleNode = slowNode;
//        ListNode leftNode = head;
//        ListNode rightNode = middleNode.next;
//        middleNode.next = null;
//        leftNode = sortList(leftNode);
//        rightNode = sortList(rightNode);
//        ListNode emptyNode = new ListNode(0);
//        ListNode currentNode = emptyNode;
//        while (leftNode != null && rightNode != null){
//            if (leftNode.val < rightNode.val){
//                currentNode.next = leftNode;
//                leftNode = leftNode.next;
//            }else{
//                currentNode.next = rightNode;
//                rightNode = rightNode.next;
//            }
//            currentNode = currentNode.next;
//        }
//        while (leftNode != null){
//            currentNode.next = leftNode;
//            leftNode = leftNode.next;
//            currentNode = currentNode.next;
//        }
//        while (rightNode != null){
//            currentNode.next = rightNode;
//            rightNode = rightNode.next;
//            currentNode = currentNode.next;
//        }
//        return emptyNode.next;
//    }
}