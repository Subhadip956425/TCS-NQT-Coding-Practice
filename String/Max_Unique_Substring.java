//////////////////////////////////////////////

package String;

import java.util.HashMap;

public class Max_Unique_Substring {
    public static void main(String[] args) {
        String input = "abcabcdbb";
        System.out.println("Input: " + input);
        String longest = longestUniqueSubstring(input);
        System.out.println("Longest substring without repeating characters: " + longest);
        System.out.println("Length: " + longest.length());
    }

    public static String longestUniqueSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int start = 0;
        int maxStart = 0;

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);

            if (map.containsKey(ch) && map.get(ch) >= start) {
                start = map.get(ch) + 1;
            }

            map.put(ch, end);

            if (end - start + 1 > maxLen) {
                maxLen = end - start + 1;
                maxStart = start;
            }
        }

        return s.substring(maxStart, maxStart + maxLen);
    }
}
