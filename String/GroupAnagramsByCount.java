/// //////////////////

package String;

import java.util.*;

public class GroupAnagramsByCount {

    public static void main(String[] args) {
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagrams(input);

        for (List<String> group : result) {
            System.out.println(group);
        }
    }

    private static List<List<String>> groupAnagrams(String[] input) {

        Map<String, List<String>> anagramGroups = new HashMap<>();

        for(String word : input) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            anagramGroups.putIfAbsent(sortedWord, new ArrayList<>());
            anagramGroups.get(sortedWord).add(word);
        }
        return new ArrayList<>(anagramGroups.values());
    }
}
