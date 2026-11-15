///////////////////////////////


package String;

public class MinimumWindowSubstring {


    static String minWindow (String S, String t) {
        int[] cnt = new int[128];
        int less = 0;
        for(char c : t.toCharArray()) {
            if(cnt[c] == 0) {
                less++;
            }
            cnt[c]++;
        }

        char[] s = S.toCharArray();
        int m = s.length;
        int ansLeft = -1;
        int ansRight = m;

        int left = 0;
        for (int right=0; right<m; right++) {
            char c = s[right];
            cnt[c]--;

            if (cnt[c] == 0) {
                less--;
            }

            while (less == 0) {
                if (right - left < ansRight - ansLeft) {
                    ansRight = right;
                    ansLeft = left;
                }

                char x = s[left];
                if (cnt[x] == 0) {
                    less++;
                }
                cnt[x]++;
                left++;
            }
        }

        return ansLeft < 0 ? "" : S.substring(ansLeft, ansRight + 1);
    }
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = minWindow(s, t);
        System.out.println("Minimum window substring: " + result); // Output: "BANC"
    }
}
