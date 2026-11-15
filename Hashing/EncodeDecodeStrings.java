/// ///////////////////////

package Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeStrings {

    public static void main(String[] args) {
        List<String> input1 = Arrays.asList("neet", "code", "love", "you");
        String encoded1 = encode(input1);
        System.out.println("Encoded: " + encoded1);
        System.out.println("Decoded: " + decode(encoded1));

        List<String> input2 = Arrays.asList("we", "say", ":", "yes");
        String encoded2 = encode(input2);
        System.out.println("Encoded: " + encoded2);
        System.out.println("Decoded: " + decode(encoded2));
    }

        public static String encode(List<String> strs) {

            StringBuilder sb = new StringBuilder();

            for (String str : strs) {
                sb.append(str.length()).append('#').append(str);
            }

            return sb.toString();
        }

        public static List<String> decode(String str) {

            List<String> ans = new ArrayList<>();

            int i = 0;

            while (i < str.length()) {
                int j = i;

                while (str.charAt(j) != '#') {
                    j++;
                }

                int length = Integer.parseInt(str.substring(i, j));

                ans.add(str.substring(j+1, j+1+length));

                i = j+1+length;
            }

            return ans;
        }
    }

