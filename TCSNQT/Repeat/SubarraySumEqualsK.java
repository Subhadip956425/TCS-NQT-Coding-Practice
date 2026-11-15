/// ///////////////////////////////////////////////
///
/// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to
/// k. A subarray is a contiguous non-empty sequence of elements within an array.
/// Sample test case 1 :-
/// Input:
/// nums = 1 2 3 -3 1 1 1
/// k = 3
/// Output:
/// 6

package TCSNQT.Repeat;

import java.util.HashMap;
import java.util.Scanner;

public class SubarraySumEqualsK {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for(int num : nums){

            prefixSum += num;

            if(map.containsKey(prefixSum - k)){
                count += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        System.out.println(count);

        sc.close();
    }
}