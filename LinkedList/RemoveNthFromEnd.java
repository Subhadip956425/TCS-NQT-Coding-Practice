/// ////////////////////////////////////////

package LinkedList;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
class RemoveNthFromEnd {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Dummy node before head (for edge cases)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy, slow = dummy;

        // Step 1: Move fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Step 2: Move both until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Step 3: Remove the nth node
        slow.next = slow.next.next;

        return dummy.next;
    }

    // Helper: print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RemoveNthFromEnd solver = new RemoveNthFromEnd();

        // Example 1: [1,2,3,4,5], n=2 → [1,2,3,5]
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        System.out.print("Original: ");
        printList(head1);
        ListNode result1 = solver.removeNthFromEnd(head1, 2);
        System.out.print("After removing 2nd from end: ");
        printList(result1);

        // Example 2: [1], n=1 → []
        ListNode head2 = new ListNode(1);
        System.out.print("Original: ");
        printList(head2);
        ListNode result2 = solver.removeNthFromEnd(head2, 1);
        System.out.print("After removing 1st from end: ");
        printList(result2);

        // Example 3: [1,2], n=1 → [1]
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        System.out.print("Original: ");
        printList(head3);
        ListNode result3 = solver.removeNthFromEnd(head3, 1);
        System.out.print("After removing 1st from end: ");
        printList(result3);
    }
}
