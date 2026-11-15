/// ////////////////////////////
/// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/


package TCSNQT;

import java.util.*;

class PhoneLetterCombinations {

    static String[] map = {
        "",     "",     // 0,1 (unused)
        "abc",  "def",  "ghi",
        "jkl",  "mno",  "pqrs",
        "tuv",  "wxyz"
    };

    public static void generate(String digits, int index, String current, List<String> result) {

        // Base case
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            generate(digits, index + 1,
                     current + letters.charAt(i),
                     result);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String digits = sc.next();

        List<String> result = new ArrayList<>();

        if (digits.length() > 0) {
            generate(digits, 0, "", result);
        }

        // Print output
        for (String s : result) {
            System.out.println(s);
        }

        sc.close();
    }
}