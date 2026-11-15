/// ////////////////////////////////
/// https://leetcode.com/problems/subsets/description/

package TCSNQT.Repeat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class SubsetGenerator {

    public static void generateSubsets(int[] nums, int index, List<Integer> current) {
        // Print current subset
        printSubset(current);

        for (int i = index; i < nums.length; i++) {
            // Skip duplicates
            if (i > index && nums[i] == nums[i - 1]) continue; ///

            current.add(nums[i]);                  // choose
            generateSubsets(nums, i + 1, current); // explore   /////////////////
            current.remove(current.size() - 1);    // backtrack
        }
    }

    // Print subset in TCS format
    public static void printSubset(List<Integer> subset) {
        if (subset.size() == 0) {
            System.out.println("[]");
            return;
        }

        System.out.print("[");
        for (int i = 0; i < subset.size(); i++) {
            System.out.print(subset.get(i));
            if (i != subset.size() - 1) System.out.print(" ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums); // 🔥 important

        List<Integer> current = new ArrayList<>();

        generateSubsets(nums, 0, current);

        sc.close();
    }
}