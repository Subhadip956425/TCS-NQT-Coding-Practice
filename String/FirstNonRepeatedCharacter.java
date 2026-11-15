package String;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {
    public static void main(String[] args) {
        String str = "swiss";
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        for (char ch : charCount.keySet()) {
            int entry = charCount.get(ch);
            if (entry == 1) {
                System.out.println(ch);
                break;
            }
        }
    }
}
