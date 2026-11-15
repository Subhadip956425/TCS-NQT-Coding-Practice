// Need to repeat
// https://leetcode.com/problems/group-anagrams/description/


package TCSNQT.Repeat;

import java.util.*;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();   ////////////////////

        for (String str : strs) {

            // Convert to char array and sort
            char[] chars = str.toCharArray();  ///////
            Arrays.sort(chars); ////////////

            String key = new String(chars);  /////////

            // Put in map
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>()); ///////
            }

            map.get(key).add(str);   //////////////////////
        }

        return new ArrayList<>(map.values());   //////////////////


//        For direct print
//        for (List<String> list : map.values()) {   ///////////////////
//          System.out.println(list);
//        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] strs = new String[n];

        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }

        // Function call
        List<List<String>> result = groupAnagrams(strs);  ////////////////

        // Output
        for (List<String> list : result) { ///////////////////////////
            System.out.println(list);
        }

        sc.close();
    }
}