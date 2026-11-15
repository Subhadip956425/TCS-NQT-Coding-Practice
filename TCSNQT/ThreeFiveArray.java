// Given size of n and list of array elements and we should print if the given element in array is divisible by 3
//then replace the element with "Three" and if the element in array is divisible by 5 then replace the element with "Five" if the element
//divisible by 3 and 5 both then replace the element with "ThreeFive" if the element in the array is not satisfying the above 3 conditions
//then put the element as it is and print the array
//Sample test case 1 :-
//Input:
//N=4
//[2 3 4 5]
//Output:
//2 Three 4 Five
//Sample test case 2 :-
//Input:
//N=2
//[15  3]
//Output:
//ThreeFive Three

package TCSNQT;

import java.util.*;

public class ThreeFiveArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++){

            if(arr[i] % 3 == 0 && arr[i] % 5 == 0)
                System.out.print("ThreeFive ");
            else if(arr[i] % 3 == 0)
                System.out.print("Three ");
            else if(arr[i] % 5 == 0)
                System.out.print("Five ");
            else
                System.out.print(arr[i] + " ");
        }
    }
}