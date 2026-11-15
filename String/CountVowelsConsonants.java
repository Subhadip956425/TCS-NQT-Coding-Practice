package String;

import java.util.*;

public class CountVowelsConsonants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input string
        String str = sc.nextLine();
        str = str.toLowerCase(); // For case-insensitive comparison
        
        int vowels = 0, consonants = 0;
        
        for (char ch : str.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') { // Consider only letters
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                    vowels++;
                else
                    consonants++;
            }
        }
        
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        
        sc.close();
    }
}
