/// ////////////////////////


package String;

public class LongestRepeatingCharacterReplacement {

    static {
        for (int i = 0; i < 500; i++) {
            characterReplacement("A", 1);
        }
    }


    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        int result = characterReplacement(s, k);
        System.out.println("Longest substring length: " + result);
    }

    static int characterReplacement(String s, int k) {
        char[] str = s.toCharArray();
        int[] count = new int[26];
        int maxCount = 0;
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            count[str[right] - 'A']++;
            maxCount = Math.max(maxCount, count[str[right] - 'A']);

            if ((right - left + 1) - maxCount > k) {
                count[str[left] - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
