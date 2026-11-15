/// //////////////////////////
/// https://leetcode.com/problems/wildcard-matching/description/


package TCSNQT;

import java.util.*;

public class WildcardMatching {

    public static boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        int starIndex = -1, matchIndex = -1;

        while (i < s.length()) {

            // Case 1: Match or '?'
            if (j < p.length() && 
               (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')) {
                i++;
                j++;
            }

            // Case 2: '*'
            else if (j < p.length() && p.charAt(j) == '*') {
                starIndex = j;
                matchIndex = i;
                j++;
            }

            // Case 3: Mismatch but previous '*'
            else if (starIndex != -1) {
                j = starIndex + 1;
                matchIndex++;
                i = matchIndex;
            }

            // Case 4: No match
            else {
                return false;
            }
        }

        // Check remaining pattern (should be all '*')
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }

        return j == p.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TCS-style input
        String s = sc.next();
        String p = sc.next();

        boolean result = isMatch(s, p);

        System.out.println(result);
    }
}