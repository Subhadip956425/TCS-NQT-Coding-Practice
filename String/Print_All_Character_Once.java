// //-> for only print duplicates using Map dsa but to print all caracters one used cHashSet

package String;

import java.util.HashSet;

public class Print_All_Character_Once {
    public static void main(String[] args) {
        
        String input = "I love programming";

        printUniqueCharacters(input);
    }

    static void printUniqueCharacters(String input) {

        input = input.toLowerCase().replaceAll("\\s+", "");

        // Map<Character, Integer> unique = new HashMap<>();

        HashSet<Character> unique = new HashSet<>();

        for(Character ch : input.toCharArray()) {
            // unique.put(ch, unique.getOrDefault(ch, 0) + 1);

            if (!unique.contains(ch)) {
                System.out.println(ch + " ");
                unique.add(ch);
            }
        }

        // only print unique charecters Print
        // for (Character ch : input.toCharArray()) {
        //     if(unique.get(ch) == 1) {
        //         System.out.println(ch + " ");
        //     }
        // }
    }
}
