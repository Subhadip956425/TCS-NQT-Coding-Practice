/// ///////////////////////
/// https://leetcode.com/problems/permutations/description/


package TCSNQT;

import java.util.*;

class PermutationGeneratorSwap {

    public static void generate(int[] nums, int index) {
        if (index == nums.length) {
            print(nums);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            generate(nums, index + 1);
            swap(nums, index, i); // backtrack
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void print(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i != nums.length - 1) System.out.print(" ");
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

        generate(nums, 0);

        sc.close();
    }
}