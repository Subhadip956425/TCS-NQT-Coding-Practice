///////////////////////////////////////

package TCSNQT;

import java.util.*;

public class DistinctBitwiseORSubarrays {

    public static int countDistinctOR(int[] arr) {

        Set<Integer> result = new HashSet<>();
        Set<Integer> prev = new HashSet<>();

        for(int num : arr) {

            Set<Integer> curr = new HashSet<>();

            curr.add(num);

            for(int val : prev) {
                curr.add(val | num);
            }

            result.addAll(curr);   ///////

            prev = curr;
        }

        return result.size();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(countDistinctOR(arr));
    }
}