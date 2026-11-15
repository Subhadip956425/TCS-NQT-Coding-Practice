///////////////////////////////////////////////////////////////////////////////////////////////////////////
//567. Permutation in String

package String.Doubt;

public class PermutationInString {
    public static boolean containsPermutation(String pattern, String text) {
        if (pattern.length() > text.length()) return false;

        int[] patternCount = new int[26];
        int[] windowCount = new int[26];

        // Count frequency of characters in pattern
        for (char c : pattern.toCharArray()) {
            patternCount[c - 'a']++;
        }

        int windowSize = pattern.length();
        for (int i = 0; i < text.length(); i++) {
            windowCount[text.charAt(i) - 'a']++;

            // Shrink window if size exceeds pattern length
            if (i >= windowSize) {
                windowCount[text.charAt(i - windowSize) - 'a']--;
            }

            // Check if the two frequency arrays match
            if (matches(patternCount, windowCount)) {
                return true;
            }
        }
        return false;
    }

    private static boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(containsPermutation(s1, s2)); // Output: true
    }
}
