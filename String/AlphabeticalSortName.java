package String;

import java.util.Arrays;
import java.util.Scanner;

public class AlphabeticalSortName {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full name: ");
        String name = sc.nextLine();

        // Remove spaces and convert to lowercase for uniform sorting
        String cleaned = name.replaceAll("\\s+", "").toLowerCase();

        // Convert to character array
        char[] chars = cleaned.toCharArray();

        // Sort alphabetically
        Arrays.sort(chars);

        // Convert back to string
        String sortedName = new String(chars);

        System.out.println("Name in alphabetical order: " + sortedName);

        sc.close();
    }
}
