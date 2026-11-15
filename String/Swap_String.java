package String;

public class Swap_String {
    public static void main(String[] args) {
        
        String str1 = "Hello";
        String str2 = "World";

        System.out.println("Before swapping 1st string is : " + str1 + " and 2nd string is : " + str2);

        str1 = str1 + str2;

        str2 = str1.substring(0, str1.length()-str2.length());
        str1 = str1.substring(str2.length());

        System.out.println("After swapping 1st string is : " + str1 + " and 2nd string is : " + str2);
    }
}
