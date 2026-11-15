package TCSNQT;

import java.util.*;

public class ShoePairs {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        for(int i = 0; i < n; i++) {

            String shoe = sc.next();

            int size = Integer.parseInt(shoe.substring(0, shoe.length()-1));  ///////////////////////////
            char side = shoe.charAt(shoe.length()-1); ///////////////////////////

            if(side == 'L') /// //////////////////////////
                left.put(size, left.getOrDefault(size,0) + 1);
            else
                right.put(size, right.getOrDefault(size,0) + 1);
        }

        int pairs = 0;

        for(int size : left.keySet()) {
            pairs += Math.min(left.get(size), right.getOrDefault(size,0));  /////////////////
        }

        System.out.println(pairs);
    }
}