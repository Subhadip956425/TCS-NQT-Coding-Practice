package Array;

import java.util.HashMap;

public class ValidAnagram_Using_Hashmap {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram")); // true
        System.out.println(isAnagram("rat", "car"));         // false
    }

    private static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> count = new HashMap<>();

        char[] sr = s.toCharArray();
        char[] tr = t.toCharArray();

        for (char ch : sr) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        for (char ch : tr) {
            if (!count.containsKey(ch)) return false;

            count.put(ch, count.get(ch) - 1);

            if (count.get(ch) == 0) count.remove(ch);
        }

        return count.isEmpty();
    }
}
