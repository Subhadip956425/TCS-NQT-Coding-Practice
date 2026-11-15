/// ///////////////////////////////////

package LinkedList;

// https://leetcode.com/problems/reverse-linked-list/
class ReverseLinkedList {
    
    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    // Iterative solution
    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }
        return prev;
    }

    // Recursive solution
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // Helper function to print list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ReverseLinkedList solver = new ReverseLinkedList();

        // Build linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original: ");
        printList(head);

        // Iterative
        ListNode reversed1 = solver.reverseListIterative(head);
        System.out.print("Reversed Iterative: ");
        printList(reversed1);

        // Reverse back using recursion
        ListNode reversed2 = solver.reverseListRecursive(reversed1);
        System.out.print("Reversed Recursive: ");
        printList(reversed2);
    }
}
