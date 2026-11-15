//  Print all combinations.
//Sample test case 1 :-
//Input:
//3  0123
//3 – is the size of the array
//Output:
//0, 0 1, 0 1 2, 0 1 2 3, 1, 1 2, 1 2 3, 2, 2 3, 3*



package TCSNQT.Repeat;

import java.util.Scanner;

public class Combinations {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n+1];

        for(int i = 0; i <= n; i++)
            arr[i] = sc.nextInt();

        for(int i = 0; i <= n; i++) {

            for(int j = i; j <= n; j++) {

                for(int k = i; k <= j; k++)
                    System.out.print(arr[k] + " ");

                if(!(i == n && j == n))   /// ///////////////////////////////
                    System.out.print(", ");
            }
        }
    }
}