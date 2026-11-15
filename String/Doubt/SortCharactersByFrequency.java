/// //////////////////////

package String.Doubt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s)); // Output could be "eert" or "eetr"
    }

    public static String frequencySort(String s) {

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        List<Character>[] buckets = new List[s.length() + 1];

        for (char ch : freqMap.keySet()) {
            int freq = freqMap.get(ch);

            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(ch);
        }

        StringBuilder sb = new StringBuilder();

        for (int i=buckets.length-1; i>0; i--) {
            if (buckets[i] != null) {
                for (char ch : buckets[i]) {
                    for (int j=0; j<i; j++) {
                        sb.append(ch);
                    }
                }
            }
        }

        return sb.toString();
    }
}
