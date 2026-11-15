/// ///////////////////////////////////////
/// https://leetcode.com/problems/count-and-say/description/


package TCSNQT;

import java.util.*;

public class CountAndSaySequence {

    public static String countAndSay(int n) {
        String result = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder temp = new StringBuilder();
            int count = 1;

            for (int j = 1; j < result.length(); j++) {   /// //////
                if (result.charAt(j) == result.charAt(j - 1)) {   /// ///
                    count++;
                } else {
                    temp.append(count).append(result.charAt(j - 1));   ////////
                    count = 1;
                }
            }

            // Append last group
            temp.append(count).append(result.charAt(result.length() - 1));

            result = temp.toString();
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TCS-style input
        int n = sc.nextInt();

        String result = countAndSay(n);

        System.out.println(result);
    }
}