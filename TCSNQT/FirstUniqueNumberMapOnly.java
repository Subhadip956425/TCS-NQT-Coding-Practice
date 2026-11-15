package TCSNQT;

import java.util.*;

class FirstUniqueNumberMapOnly {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

            // Update frequency
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);

            // Find first unique
            int result = -1;
            for (int j = 0; j <= i; j++) {
                if (freqMap.get(arr[j]) == 1) {
                    result = arr[j];
                    break;
                }
            }

            System.out.println(result);
        }

        sc.close();
    }
}