/// ////////////////////////////////////////


package TCSNQT.Repeat;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestUniqueSubstring {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            // Remove duplicates from left
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));   ////////////
                left++;
            }

            // Add current character
            set.add(s.charAt(right));

            // Update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TCS-style input
        String s = sc.nextLine();

        int result = lengthOfLongestSubstring(s);

        System.out.println(result);
    }
}