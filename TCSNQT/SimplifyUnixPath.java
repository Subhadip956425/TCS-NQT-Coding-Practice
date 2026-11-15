/// //////////////////////////////
/// https://leetcode.com/problems/simplify-path/description/


package TCSNQT;

import java.util.*;

public class SimplifyUnixPath {

    public static String simplifyPath(String path) {

        String[] parts = path.split("/");   //////////////
        Stack<String> stack = new Stack<>();

        for (String part : parts) {

            if (part.equals("") || part.equals(".")) {
                continue;

            } else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }

            } else {
                stack.push(part);
            }
        }

        // Build result
        StringBuilder result = new StringBuilder();

        for (String dir : stack) {
            result.append("/").append(dir);
        }

        return result.length() == 0 ? "/" : result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String path = sc.nextLine();

        System.out.println(simplifyPath(path));

        sc.close();
    }
}