// Need to repeat
// https://leetcode.com/problems/gas-station/description/

package TCSNQT.Repeat;

import java.util.Scanner;

public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0;
        int totalCost = 0;

        // Step 1: Check overall feasibility
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if (totalGas < totalCost) {
            return -1;
        }

        // Step 2: Find starting point
        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {

            tank += gas[i] - cost[i];

            // If tank becomes negative → reset
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] gas = new int[n];
        int[] cost = new int[n];

        for (int i = 0; i < n; i++) gas[i] = sc.nextInt();
        for (int i = 0; i < n; i++) cost[i] = sc.nextInt();

        int result = canCompleteCircuit(gas, cost);

        System.out.println(result);

        sc.close();
    }
}