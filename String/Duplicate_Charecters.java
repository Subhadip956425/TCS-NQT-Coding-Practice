///////////////////////////////////////////

package String;

import java.util.HashMap;
import java.util.Map;

public class Duplicate_Charecters {
    
    public static void main(String[] args) {
        
        String input = "Hello I am a final year student!";

        findDuplicateCharacters(input);
    }

    static void findDuplicateCharacters(String input) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (Character ch : input.toCharArray()) {
            if (Character.isWhitespace(ch)) {
                continue;
            }
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        System.out.println("Duplicate characters are : ");

        System.out.println(charCount); //

        for (char ch : charCount.keySet()) {
            int count = charCount.get(ch);
            if (count > 1) {
                System.out.println(ch + " -> " + count);
            }
        }

    }
}
