// Top candidate need to be printed from the given input.
//Sample test case 1 :-
//Input:
//3 4 90 John 85 Bob 92 Alice 110 Aditya
//Output:
//Aditya: 110
//Alice: 100
//John: 90

package TCSNQT.Repeat;

import java.util.Scanner;

public class TopCandidate {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();

        int[] marks = new int[n];
        String[] names = new String[n];

        for(int i = 0; i < n; i++) {  ///////////////////////
            marks[i] = sc.nextInt();
            names[i] = sc.next();
        }

        // simple sorting (descending)
        for(int i = 0; i < n-1; i++) {     /// ////////////////////
            for(int j = i+1; j < n; j++) {   /// //////////////////

                if(marks[i] < marks[j]) {

                    int tempMarks = marks[i];
                    marks[i] = marks[j];
                    marks[j] = tempMarks;

                    String tempName = names[i];
                    names[i] = names[j];
                    names[j] = tempName;
                }
            }
        }

        // print top k candidates
        for(int i = 0; i < k; i++) {
            System.out.println(names[i] + ": " + marks[i]);
        }
    }
}