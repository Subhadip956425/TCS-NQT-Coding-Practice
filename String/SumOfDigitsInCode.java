package String;

import java.util.*;

public class SumOfDigitsInCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String S = sc.nextLine(); // Input the alphanumeric string
        
        int sum = 0;
        for (char ch : S.toCharArray()) {
            if (Character.isDigit(ch)) {
                sum += ch - '0'; // Convert char digit to int and add
            }
        }
        
        System.out.println(sum);
        sc.close();
    }
}
