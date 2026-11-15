///////////////////////////////////

package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {
    
    static List<Integer> findAnagrams(String s, String p) {
        int plen = p.length();
        int slen = s.length();
        int[] scount = new int[26];
        int[] pcount = new int[26];

        List<Integer> ans = new ArrayList<>();

        if (plen > slen) {
            return ans;
        }

        for(int i=0; i<plen; i++) {
            pcount[p.charAt(i) - 'a']++;
            scount[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pcount, scount)) {
            ans.add(0);
        }

        for (int i=plen; i<slen; i++) {
            scount[s.charAt(i) - 'a']++;
            scount[s.charAt(i - plen) - 'a']--;

            if (Arrays.equals(pcount, scount)) {
                ans.add(i - plen + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        List<Integer> indices = findAnagrams(s, p);
        System.out.println(indices);
    }
}
