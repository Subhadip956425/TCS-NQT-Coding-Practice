/// ////////////////////////////
/// https://leetcode.com/problems/combinations/description/


package TCSNQT.Revise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CombinationGenerator {

    public static void generate(int n, int k, int start, List<Integer> current) {

        // Base case
        if (current.size() == k) {
            print(current);
            return;
        }

        // Optimized loop (pruning)
        for (int i = start; i <= n - (k - current.size()) + 1; i++) {  //////
            current.add(i);

            generate(n, k, i + 1, current);   ///////////////

            // Backtrack
            current.remove(current.size() - 1);   //////////
        }
    }

    public static void print(List<Integer> list) {   /// ////////////////////
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
        int k = sc.nextInt();

        List<Integer> current = new ArrayList<>();  //////////

        generate(n, k, 1, current);

        sc.close();
    }
}