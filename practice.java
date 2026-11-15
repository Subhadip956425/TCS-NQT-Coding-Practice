import java.util.*;

public class practice {
    public static void main(String[] args) {
        String[] input = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagrams(input);

        for (List<String> group : result) {
            System.out.println(group);
        }
    }

    private static List<List<String>> groupAnagrams(String[] input) {

        Map<String, List<String>> ans = new HashMap<>();

        for (String str : input) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);

            ans.putIfAbsent(key, new ArrayList<>());

            ans.get(key).add(str);
        }

        return new ArrayList<>(ans.values());
    }
}
