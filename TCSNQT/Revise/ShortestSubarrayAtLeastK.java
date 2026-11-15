/// //////////////////////////////////////
/// https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/


package TCSNQT.Revise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ShortestSubarrayAtLeastK {

    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {

            // Check if valid subarray found
            while (!dq.isEmpty() && prefix[i] - prefix[dq.peekFirst()] >= k) {
                minLength = Math.min(minLength, i - dq.pollFirst());
            }

            // Maintain increasing order
            while (!dq.isEmpty() && prefix[i] <= prefix[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.offerLast(i);
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(shortestSubarray(nums, k));

        sc.close();
    }
}