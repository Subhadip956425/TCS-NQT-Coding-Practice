package String;

public class CompressString {
    public static void main(String[] args) {
        String input = "aabbbffddeyyhhssttt";

        System.out.println("Input: " + input);
        System.out.println("Output: " + compress(input));
    }

    static String compress(String input) {
        StringBuilder res = new StringBuilder();

        int count = 1;

        for(int i=1; i<input.length(); i++) {
            if(input.charAt(i) == input.charAt(i-1)) {
                count++;
            } else {
                // res.append(input.charAt(i-1));
                // if(count > 1) {    // If for unique character no need of print 1
                //      res.append(count); 
                // }
                res.append(input.charAt(i-1)).append(count);   // If for unique character need to print 1
                count = 1;
            }
        }

        // res.append(input.charAt(i-1));
                // if(count > 1) {    // If for unique character no need of print 1
                //      res.append(count); 
                // }

        res.append(input.charAt(input.length()-1)).append(count);

        return res.toString();
    }
}
