package TCSNQT;

import java.util.*;

public class NearestDivisible {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int Y = sc.nextInt();

        int remainder = X % Y;

        int lower = X - remainder;
        int higher = X + (Y - remainder);   //////////////////////////////

        if(remainder <= Y - remainder)  /// /////////////////////////
            System.out.println(lower);
        else
            System.out.println(higher);
    }
}