/// ///////////////////////////
/// https://leetcode.com/problems/reverse-nodes-in-k-group/description/



package TCSNQT;

import java.util.*;

class ReverseKGroup {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head;
        int count = 0;

        // Step 1: Check if k nodes exist
        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }

        // If k nodes exist → reverse
        if (count == k) {

            curr = reverseKGroup(curr, k); // recursive for next part

            // Reverse current k nodes
            while (count-- > 0) {
                ListNode next = head.next;
                head.next = curr;
                curr = head;
                head = next;
            }

            head = curr;
        }

        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ListNode head = null, temp = null;

        for (int i = 0; i < n; i++) {
            ListNode node = new ListNode(sc.nextInt());
            if (head == null) {
                head = node;
                temp = head;
            } else {
                temp.next = node;
                temp = temp.next;
            }
        }

        int k = sc.nextInt();

        head = reverseKGroup(head, k);

        // Print result
        temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        sc.close();
    }
}