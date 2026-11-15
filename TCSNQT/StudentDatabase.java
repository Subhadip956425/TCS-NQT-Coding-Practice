package TCSNQT;

import java.util.*;

public class StudentDatabase {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<String> names = new ArrayList<>();
        int asciiSum = 0;
        int femaleCount = 0;

        for(int i = 0; i < n; i++) {

            String name = sc.next();
            int age = sc.nextInt();
            char grade = sc.next().charAt(0); /////////////////////
            String gender = sc.next();

            if(age > 20) {
                names.add(name);
            }

            if(gender.equalsIgnoreCase("Female")) {  ///////////////////
                asciiSum += (int) grade; ///////////////////
                femaleCount++;
            }
        }

        // Print names
        for(String s : names) {
            System.out.print(s + " ");
        }

        System.out.println();

        // Print average ASCII
        if(femaleCount > 0)
            System.out.println(asciiSum / femaleCount);
    }
}