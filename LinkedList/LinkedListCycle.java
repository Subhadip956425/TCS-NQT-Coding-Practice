package LinkedList;

// https://leetcode.com/problems/linked-list-cycle/
class LinkedListCycle {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle solver = new LinkedListCycle();

        // Example 1: 3 -> 2 -> 0 -> -4 -> back to 2
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // create cycle

        System.out.println(solver.hasCycle(head)); // Output: true

        // Example 2: 1 -> 2 -> back to 1
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = head2; // cycle at node 0
        System.out.println(solver.hasCycle(head2)); // Output: true

        // Example 3: 1 -> null (no cycle)
        ListNode head3 = new ListNode(1);
        System.out.println(solver.hasCycle(head3)); // Output: false
    }
}
