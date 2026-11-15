/// /////////////////////////////////
/// https://leetcode.com/problems/jump-game-ii/description/


package TCSNQT;

import java.util.*;

public class JumpGameII {

    public static int jump(int[] nums) {

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {   /// /////////////////////////////////

            farthest = Math.max(farthest, i + nums[i]);

            // When we reach end of current jump
            if (i == currentEnd) {    /// ////////////////////
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = jump(nums);

        System.out.println(result);

        sc.close();
    }
}