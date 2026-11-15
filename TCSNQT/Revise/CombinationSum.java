/// ///////////////////////////////////////////
/// https://leetcode.com/problems/combination-sum/description/

package TCSNQT.Revise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, candidates, target, new ArrayList<>(), result);
        return result;
    }

    public static void backtrack(int index, int[] candidates, int target,
                                 List<Integer> current, List<List<Integer>> result) {

        // Base case
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            // Choose
            current.add(candidates[i]);

            // Stay at same index (reuse allowed)
            backtrack(i, candidates, target - candidates[i], current, result);

            // Backtrack (undo choice)
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int n = sc.nextInt();
        int[] candidates = new int[n];

        for (int i = 0; i < n; i++) {
            candidates[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        // Function call
        List<List<Integer>> result = combinationSum(candidates, target);

        // Output
        for (List<Integer> list : result) {
            System.out.println(list);
        }

        sc.close();
    }
}