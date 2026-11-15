/// ////////////////////////////////
/// https://leetcode.com/problems/subsets/description/


package TCSNQT;

import java.util.*;

class SubsetGeneratorIterative {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>()); // start with empty subset

        // -------- 2 Loop Logic --------
        for (int i = 0; i < n; i++) {
            int size = subsets.size();

            for (int j = 0; j < size; j++) {
                List<Integer> newSubset = new ArrayList<>(subsets.get(j));
                newSubset.add(nums[i]);
                subsets.add(newSubset);
            }
        }

        // Print result
        for (List<Integer> subset : subsets) {
            if (subset.size() == 0) {
                System.out.println("[]");
                continue;
            }

            System.out.print("[");
            for (int i = 0; i < subset.size(); i++) {
                System.out.print(subset.get(i));
                if (i != subset.size() - 1) System.out.print(" ");
            }
            System.out.println("]");
        }

        sc.close();
    }
}