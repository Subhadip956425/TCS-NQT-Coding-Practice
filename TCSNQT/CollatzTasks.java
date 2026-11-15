/// ///////////////////////////////

//  Task 1- print the collatz sequence upto ending with 1 the sequence should be in the following way -> if the number is even:
//F(n)=n//2 -> if the number is odd:
//F(n)=3*n+1
//This sequence should end until the last element of sequence is 1
//Task-2
//For the given integer from 1,n it should calculate the sequence of each k value l.e, 1<=k<=n
//Calculate the maximum length of sequence list of each k value and return the maximum length of the sequence list of the k value
//and the k value itself
//Task-3
//For the given integer from 1.n it should calculate the sequence of each k value le, 1<=k<=n Calculate the maximum value of the each
//sequence within the sequence list of each k value and return the maximum value of the sequence list of the k value and those k value
//itself
//Sample test case 1 :-
//Input: 5
//Output:
//[5,16,8,4,2,1]
//8,3
//16,3
//By : Sreejita Dhar
//Sample test case 2 :-
//Input:
//0
//Output:
//Error!
//Sample test case 3 :-
//Input:
//xyza
//Output:
//Error!
//Sample test case 4 :-
//Input:
//13
//Output:
//Error!
//Sample test case 5 :-
//Input:
//5.5
//Output:
//Error!

package TCSNQT;

import java.util.*;

public class CollatzTasks {

    public static List<Integer> collatz(int n) {

        List<Integer> seq = new ArrayList<>();
        seq.add(n);

        while(n != 1) {

            if(n % 2 == 0)
                n = n / 2;
            else
                n = 3 * n + 1;

            seq.add(n);
        }

        return seq;  ////////////////////////////////////
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

//        try {
//    int n = sc.nextInt();
//
//    if (n <= 0 || n > 12) {
//        System.out.println("Error!");
//        return;
//    }
//
//} catch (Exception e) {
//    System.out.println("Error!");
//    return;
//}

        if(!sc.hasNextInt()){   /// /////
            System.out.println("Error!");
            return;
        }

        int n = sc.nextInt();

        if(n <= 0 || n > 12){
            System.out.println("Error!");
            return;
        }

        // Task 1
        List<Integer> seq = collatz(n);  /////////////////////////
        System.out.println(seq);

        int maxLen = 0, lenK = 0;
        int maxValue = 0, valK = 0;

        // Task 2 & Task 3
        for(int k = 1; k <= n; k++){

            List<Integer> temp = collatz(k);

            if(temp.size() > maxLen){
                maxLen = temp.size();  //////////
                lenK = k;
            }

            int localMax = Collections.max(temp);  //////////////

            if(localMax > maxValue){
                maxValue = localMax;
                valK = k;
            }
        }

        System.out.println(maxLen + "," + lenK);
        System.out.println(maxValue + "," + valK);
    }
}