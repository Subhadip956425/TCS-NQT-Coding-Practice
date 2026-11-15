package TCS_NQT_Concept;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class KeywordChecker {
    private static final Set<String> KEYWORDS = new HashSet<>(Arrays.asList(
        "break", "case", "continue", "default", "defer",
        "else", "for", "func", "goto", "if",
        "map", "range", "return", "struct", "type", "var"
    ));

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = sc.next();
        

        if (KEYWORDS.contains(word)) {
            System.out.println(word + " is a keyword.");
        } else {
            System.out.println(word + " is not a keyword.");
        }

        sc.close();
    }

}
