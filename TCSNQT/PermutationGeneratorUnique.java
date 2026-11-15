package TCSNQT;

import java.util.*;

public class PermutationGeneratorUnique {

    public static void generate(int[] nums, boolean[] visited, List<Integer> current) {

        if (current.size() == nums.length) {
            print(current);
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (visited[i]) continue;

            // 🔑 Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;

            visited[i] = true;
            current.add(nums[i]);

            generate(nums, visited, current);

            // Backtrack
            current.remove(current.size() - 1);
            visited[i] = false;
        }
    }

    public static void print(List<Integer> list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i != list.size() - 1) System.out.print(" ");
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

        Arrays.sort(nums); // 🔑 Mandatory

        boolean[] visited = new boolean[n];
        List<Integer> current = new ArrayList<>();

        generate(nums, visited, current);

        sc.close();
    }
}