//////////////////////////////

package String;

public class String_Permutations {
    
    public static void main(String[] args) {
        String str = "ABC";

        generatePermutation(str, 0, str.length()-1);
    }

    public static void generatePermutation(String str, int left, int right) {

        if(left == right) {
            System.out.println(str);
        } else {
            for (int i=left; i<=right; i++) {
                str = swap(str, left, i);

                // Recurse for next index
                generatePermutation(str, left+1, right);

                // Backtrack (Undo swap)
                str = swap(str, left, i);
            }
        }
    }

    public static String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return String.valueOf(chars);
    }
}
