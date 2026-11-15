// Need to repeat
// https://leetcode.com/problems/minimum-window-substring/description/

package TCSNQT;

import java.util.*;

public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {

        int minLen = Integer.MAX_VALUE;
        String result = "";

        for (int i = 0; i < s.length(); i++) {

            HashMap<Character, Integer> map = new HashMap<>();

            // Initialize frequency of t
            for (char c : t.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            for (int j = i; j < s.length(); j++) {

                char c = s.charAt(j);

                if (map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                }

                // Check if all characters matched
                if (isValid(map)) {
                    if ((j - i + 1) < minLen) {
                        minLen = j - i + 1;
                        result = s.substring(i, j + 1);
                    }
                    break; // no need to expand further   /////////////////
                }
            }
        }

        return result;
    }

    // Check if all required chars are used
    public static boolean isValid(HashMap<Character, Integer> map) {
        for (int val : map.values()) {   /// ///////
            if (val > 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String t = sc.nextLine();

        String result = minWindow(s, t);

        System.out.println(result);

        sc.close();
    }
}