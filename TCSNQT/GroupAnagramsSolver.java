// Need to repeat
// https://leetcode.com/problems/group-anagrams/description/


package TCSNQT;

import java.util.*;

public class GroupAnagramsSolver {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            // Convert string to char array and sort
            char[] chars = str.toCharArray();   ////////
            Arrays.sort(chars); //////

            String key = new String(chars); ////////

            // Add to map
            map.putIfAbsent(key, new ArrayList<>());   ///////////////
            map.get(key).add(str);  /////////////////
        }

        return new ArrayList<>(map.values()); ////////////////
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TCS-style input
        int n = sc.nextInt();
        String[] strs = new String[n];

        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }

        List<List<String>> result = groupAnagrams(strs);

        // Output
        for (List<String> group : result) {
            for (String word : group) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }
}