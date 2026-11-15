package String;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueCharacterIdentifier {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Using LinkedHashSet to maintain insertion order
        Set<Character> uniqueChars = new LinkedHashSet<>();

        for (char ch : input.toCharArray()) {
            uniqueChars.add(ch);
        }

        // Build result string
        StringBuilder result = new StringBuilder();
        for (char ch : uniqueChars) {
            result.append(ch);
        }

        System.out.println("String with unique characters: " + result);

        sc.close();
    }
}
