//  You are tasked with writing a program to calculate the total shipping cost based on the weight of the
//package and the distance it needs to travel. The shipping cost is determined by the following criteria:
//1. Base money: $5.00
//2. Cost per kilogram: $2.00
//3. Cost per 10 kilometers: $0.5
//Sample test case 1 :-
//Input:
//10 (w)
//100 (D)
//Output:
//$30.00

package TCSNQT;

import java.util.*;

public class ShippingCostCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();   // weight in kg
        int D = sc.nextInt();   // distance in km

        double baseCost = 5.0;
        double weightCost = w * 2.0;
        double distanceCost = (D / 10.0) * 0.5; /////////////////////////

        double totalCost = baseCost + weightCost + distanceCost;

        System.out.printf("$%.2f", totalCost);  ///////////////////

        sc.close();
    }
}