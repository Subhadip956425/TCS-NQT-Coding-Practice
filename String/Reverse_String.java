package String;

public class Reverse_String {
    
    public static void main(String[] args) {
        String s = "Hello I am";

        // String rev = new StringBuilder(s).reverse().toString(); // Using StringBuilder

        // Using for loop
        String rev = "";
        for (int i=s.length()-1; i>=0; i--) {
            rev += s.charAt(i);
        }

        System.out.println(rev);
    }
}
