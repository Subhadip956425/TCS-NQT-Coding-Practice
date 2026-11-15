/// ////////////////////////
/// https://leetcode.com/problems/zigzag-conversion/description/


package TCSNQT;

import java.util.*;

public class ZigzagConversion {

    public static String convert(String s, int numRows) {
        // Edge case
        if (numRows == 1 || s.length() <= numRows) return s;  ///////

        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);  /////////

            // Change direction at top or bottom
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            currentRow += goingDown ? 1 : -1;
        }

        // Combine all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {    /// ///
            result.append(row);   /////
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TCS-style input
        String s = sc.nextLine();
        int numRows = sc.nextInt();

        String result = convert(s, numRows);

        System.out.println(result);
    }
}