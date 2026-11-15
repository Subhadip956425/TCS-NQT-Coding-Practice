package TCSNQT;

import java.util.*;

public class RemoveDuplicateStrings {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String[] words = input.split(" ");

        Set<String> set = new HashSet<>();

        // Remove duplicates
        for(String word : words) {
            set.add(word.toLowerCase());   ////////////////
        }

        // Convert to list for sorting
        List<String> list = new ArrayList<>(set);   /////////////////

        Collections.sort(list); //////////////////

        // Print sorted words
        for(String word : list) {
            System.out.print(capitalize(word) + " ");
        }

        System.out.println();

        // Print reverse order
        for(int i = list.size() - 1; i >= 0; i--) {
            System.out.print(capitalize(list.get(i)) + " ");
        }

        sc.close();
    }

    // Method to capitalize first letter
    public static String capitalize(String word) {       ///////////////////
        return word.substring(0,1).toUpperCase() + word.substring(1);
    }  ///////////////////
}