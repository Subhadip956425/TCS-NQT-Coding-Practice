//////////////////////////////////////

package TCSNQT.Revise;

import java.util.*;

public class SubarrayPrint {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        Map<Integer, List<Integer>> map = new HashMap<>();

        // prefix sum 0 at index -1
        map.put(0, new ArrayList<>(Arrays.asList(-1)));   ///////////////////

        int prefixSum = 0;

        for (int j = 0; j < n; j++) {

            prefixSum += nums[j];

            if (map.containsKey(prefixSum - k)) {  ////////////
                for (int startIndex : map.get(prefixSum - k)) {  /////////////////

                    // print subarray from startIndex+1 to j
                    for (int x = startIndex + 1; x <= j; x++) {
                        System.out.print(nums[x] + " ");
                    }
                    System.out.println();
                }
            }

            // store index
            map.computeIfAbsent(prefixSum, x -> new ArrayList<>()).add(j);
        }

        sc.close();
    }
}