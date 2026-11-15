package TCSNQT.Repeat;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MajorityElements {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1); //////////////////////
        }

        int limit = n / 2;

        for(int key : map.keySet()) { /// //////////////////
            if(map.get(key) >= limit)
                System.out.print(key + " ");
        }
    }
}