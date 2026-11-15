package String;

public class Count_Vowel_Consonent {
    public static void main(String[] args) {
        String str1 = "I love my parents";

        int vowel=0, consonent=0;

        for(char ch : str1.toLowerCase().toCharArray()) {
            if (Character.isLetter(ch)) {   // Or can use (ch >= 'a' && ch<='z')
                if ("aeiou".indexOf(ch) >= 0) {  // or can use (ch=='a' || ch=='e'...... || ch=='u')
                    vowel++;
                } else {
                    consonent++;
                }
            }
        }

        System.out.println("vowels: " + vowel);
        System.out.println("consonent: " + consonent);
    }
}
