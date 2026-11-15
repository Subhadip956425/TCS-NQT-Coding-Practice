////////////////////////////////////////////

package String;

public class Reverse_Each_Word {
    

    public static void main(String[] args) {
        String s = "Hello I am a final year student!";

        String[] words = s.split("\\s+");

        StringBuilder result = new StringBuilder();

        for (String word : words) {
            StringBuilder rev = new StringBuilder(word).reverse();
            result.append(rev).append(" ");
        }

        System.out.println("Result string is: " + result.toString().trim());
    }
}
