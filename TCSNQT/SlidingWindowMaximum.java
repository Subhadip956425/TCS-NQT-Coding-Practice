////////////////////////////////
/// https://leetcode.com/problems/sliding-window-maximum/description/



package TCSNQT;

import java.util.*;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> dq = new LinkedList<>(); //////////

        for (int i = 0; i < n; i++) {

            // Remove elements out of window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {   //////////
                dq.pollFirst();
            }

            // Remove smaller elements from back
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);

            // Store result
            if (i >= k - 1) {  /// ///////////////
                result[i - k + 1] = nums[dq.peekFirst()]; ///////////////
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        int[] ans = maxSlidingWindow(nums, k);

        for (int x : ans) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}