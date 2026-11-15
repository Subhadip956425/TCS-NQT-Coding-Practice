/// ////////////////////////////////////////////

package TCSNQT.Repeat;

import java.util.Scanner;

public class PasswordGenerator {

    public static boolean isValid(String s) {

        if (s.length() < 8)
            return false;

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : s.toCharArray()) {

            if (Character.isUpperCase(c))    ////////////////////////
                hasUpper = true;

            else if (Character.isLowerCase(c))        ////////////////////////
                hasLower = true;

            else if (Character.isDigit(c))      ////////////////////////
                hasDigit = true;

            else if (c == '#' || c == '@')
                hasSpecial = true;
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;       ////////////////////////
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String password = sc.next();
        int k = sc.nextInt();

        if (!isValid(password)) {
            System.out.println("Invalid Password");
            return;
        }

        StringBuilder result = new StringBuilder();

        for (char c : password.toCharArray()) {       ////////////////////////

            if (Character.isLowerCase(c)) {
                char shifted = (char) ('a' + (c - 'a' + k) % 26);       /// (char)(c + k)  /////////////////////
                result.append(shifted);
            }
            else if (Character.isUpperCase(c)) {
                char shifted = (char) ('A' + (c - 'A' + k) % 26);       ////////////////////////
                result.append(shifted);
            }
            else if (Character.isDigit(c)) {
                char shifted = (char) ('0' + (c - '0' + k) % 10);       ////////////////////////
                result.append(shifted);
            }
            else if (c == '@') {
                result.append('#');
            }
            else if (c == '#') {
                result.append('@');
            }
        }

        System.out.println(result.toString());
        sc.close();
    }
}