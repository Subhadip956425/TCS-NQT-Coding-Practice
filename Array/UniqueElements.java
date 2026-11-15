package Array;

import java.util.*;

public class UniqueElements {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,4,5,5,6,6};
        Map<Integer, Integer> countMap = new LinkedHashMap<>();

        // Count frequency of each element
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Collect elements that appear only once
        List<Integer> result = new ArrayList<>();
        for (int key : countMap.keySet()) {
            if (countMap.get(key) == 1) {
                result.add(key);
            }
        }


        // Output the result
        System.out.println(result);
    }
}
