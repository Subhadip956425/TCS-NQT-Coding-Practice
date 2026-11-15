/// //////////////////////////////////////////////
/// https://leetcode.com/problems/merge-intervals/description/

package TCSNQT.Repeat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {

        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);   //////////

        List<int[]> result = new ArrayList<>();

        // Step 2: Start with first interval
        int[] current = intervals[0];
        result.add(current);   ///////////////

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            // Check overlap
            if (next[0] <= current[1]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                current = next;
                result.add(current);
            }
        }
// Directly print
//        for (int[] interval : result) {
//            System.out.println(interval[0] + " " + interval[1]);
//        }
        
        return result.toArray(new int[result.size()][]);  ///////////////
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }

        // Function call
        int[][] result = merge(intervals);

        // Output
        for (int[] interval : result) {
            System.out.println(interval[0] + " " + interval[1]);
        }

        sc.close();
    }
}