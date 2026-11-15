package String;

public class Anagram {
    
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        if(anagramCheck(str1, str2)) {
            System.out.println(str1 + " and " + str2 + " are anagram");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagram");
        }
    }

    static boolean anagramCheck(String str1, String str2) {
        str1 = str1.replaceAll("\\s+", "").toLowerCase();
        str2 = str2.replaceAll("\\s+", "").toLowerCase();

        if(str1.length() != str2.length()) {
            return false;
        }


        int[] counts = new int[256];

        for(int i=0; i<str1.length(); i++) {
            counts[str1.charAt(i)]++;
            counts[str2.charAt(i)]--;
        }

        for(int count : counts) {
            if(count != 0) {
                return false;
            }
        }

        return true;
    }
}
