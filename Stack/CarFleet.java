/// /////////////////////////////////////////
/// LeetCode 853. Car Fleet

package Stack;

import java.util.*;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        
        // store position and time to reach target
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }
        
        // sort by position descending
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
        
        int fleets = 0;
        double fleetTime = 0.0;
        
        for (int i = 0; i < n; i++) {
            double time = cars[i][1];
            if (time > fleetTime) {
                fleets++;
                fleetTime = time;
            }
            // else: car joins existing fleet
        }
        
        return fleets;
    }

    // Main method for testing
    public static void main(String[] args) {
        CarFleet solution = new CarFleet();

        int target1 = 12, pos1[] = {10,8,0,5,3}, spd1[] = {2,4,1,1,3};
        System.out.println(solution.carFleet(target1, pos1, spd1)); // Output: 3

        int target2 = 10, pos2[] = {3}, spd2[] = {3};
        System.out.println(solution.carFleet(target2, pos2, spd2)); // Output: 1

        int target3 = 100, pos3[] = {0,2,4}, spd3[] = {4,2,1};
        System.out.println(solution.carFleet(target3, pos3, spd3)); // Output: 1
    }
}
