// Need to repeat
// https://leetcode.com/problems/baseball-game/description/


package TCSNQT;

import java.util.*;

public class BaseballGameScore {

    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();

        for (String op : ops) {

            if (op.equals("+")) {
                int last = stack.pop();
                int secondLast = stack.peek();
                int sum = last + secondLast;
                stack.push(last);
                stack.push(sum);

            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());

            } else if (op.equals("C")) {
                stack.pop();

            } else {
                stack.push(Integer.parseInt(op));  /////////////////////////////////
            }
        }

        // Calculate total sum
        int total = 0;
        for (int score : stack) {
            total += score;
        }

        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of operations
        String[] ops = new String[n];

        for (int i = 0; i < n; i++) {
            ops[i] = sc.next();
        }

        System.out.println(calPoints(ops));

        sc.close();
    }
}