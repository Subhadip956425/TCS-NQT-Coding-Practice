/// ////////////////////////////////////
/// https://leetcode.com/problems/jump-game/description/


package TCSNQT;

import java.util.*;

public class JumpGame {

    public static boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {

            // If current index is not reachable
            if (i > maxReach) {      /// //////////////////
                return false;
            }

            // Update farthest reachable index
            maxReach = Math.max(maxReach, i + nums[i]);  ///////////////////////////
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Function call
        boolean result = canJump(nums);

        // Output
        System.out.println(result);

        sc.close();
    }
}