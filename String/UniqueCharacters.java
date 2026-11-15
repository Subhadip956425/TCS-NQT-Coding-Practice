// //-> for only print duplicates using Map dsa but to print all caracters one used cHashSet

package String;

import java.util.HashMap;
import java.util.Map;

public class UniqueCharacters {
    public static void main(String[] args) {
        
        String input = "I love programming";

        printUniqueCharacters(input);
    }

    static void printUniqueCharacters(String input) {

        input = input.toLowerCase().replaceAll("\\s+", "");

        Map<Character, Integer> unique = new HashMap<>();


        for(Character ch : input.toCharArray()) {
            unique.put(ch, unique.getOrDefault(ch, 0) + 1);
        }

        for (Character ch : input.toCharArray()) {
            if(unique.get(ch) == 1) {
                System.out.println(ch + " ");
            }
        }
    }
}
