/// ////////////////////////
/// https://leetcode.com/problems/generate-parentheses/description/


package TCSNQT.Revise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ParenthesesGenerator {

    public static void generate(int n, int open, int close, String current, List<String> result) {

        // Base case
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // Add '('
        if (open < n) {
            generate(n, open + 1, close, current + "(", result);
        }

        // Add ')'
        if (close < open) {
            generate(n, open, close + 1, current + ")", result);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<String> result = new ArrayList<>();

        generate(n, 0, 0, "", result);

        // Print output (TCS style)
        for (String s : result) {
            System.out.println(s);
        }

        sc.close();
    }
}