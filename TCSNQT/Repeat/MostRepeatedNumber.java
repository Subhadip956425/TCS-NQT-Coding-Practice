// You are given an array of size n. Your task is to create a function called ‘most_repeated_number’ to find and
//print the number that occurs more than n/3 times in the array.
//Sample test case 1 :-
//Input:
//n = 9
//arr = [1,2,2,2,2,3,3,3,3]
//Output:
//[2  3]

package TCSNQT.Repeat;

import java.util.Scanner;

public class MostRepeatedNumber {

    public static void most_repeated_number(int[] arr, int n) {

        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        for(int num : arr){

            if(num == candidate1)
                count1++;
            else if(num == candidate2)
                count2++;
            else if(count1 == 0){
                candidate1 = num;
                count1 = 1;
            }
            else if(count2 == 0){
                candidate2 = num;
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }

        // verify counts
        count1 = 0;
        count2 = 0;

        for(int num : arr){
            if(num == candidate1) count1++;
            else if(num == candidate2) count2++;
        }

        System.out.print("[");

        if(count1 > n/3)
            System.out.print(candidate1 + " ");

        if(count2 > n/3)
            System.out.print(candidate2);

        System.out.println("]");
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        most_repeated_number(arr, n);
    }
}