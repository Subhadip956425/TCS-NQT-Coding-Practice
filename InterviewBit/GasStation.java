///////////////////////////

package InterviewBit;

public class GasStation {

    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {2, 1};
        System.out.println(canCompleteCircuit(A, B)); // Output: 1

        int[] A2 = {2, 3, 4};
        int[] B2 = {3, 4, 3};
        System.out.println(canCompleteCircuit(A2, B2)); // Output: -1
    }

    private static int canCompleteCircuit(int[] gas, int[] cost) {

        int totalTank = 0;
        int startIndex = 0;
        int currTank = 0;

        for (int i=0; i<gas.length; i++) {
            totalTank += gas[i] - cost[i];
            currTank += gas[i] - cost[i];

            if (currTank < 0) {
                currTank = 0;
                startIndex = i + 1;
            }
        }

        return totalTank >= 0 ? startIndex : -1;
    }
}
