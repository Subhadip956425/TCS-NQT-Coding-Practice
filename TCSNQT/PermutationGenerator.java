/// ///////////////////////
/// https://leetcode.com/problems/permutations/description/


package TCSNQT;

import java.util.*;

class PermutationGenerator {

    public static void generatePermutations(int[] nums, boolean[] visited, List<Integer> current) {

        // Base case
        if (current.size() == nums.length) {
            printPermutation(current);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            current.add(nums[i]);

            generatePermutations(nums, visited, current);

            // Backtrack
            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }

    // Print in TCS format
    public static void printPermutation(List<Integer> perm) {
        System.out.print("[");
        for (int i = 0; i < perm.size(); i++) {
            System.out.print(perm.get(i));
            if (i != perm.size() - 1) System.out.print(" ");
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

        boolean[] visited = new boolean[n];
        List<Integer> current = new ArrayList<>();

        generatePermutations(nums, visited, current);

        sc.close();
    }
}