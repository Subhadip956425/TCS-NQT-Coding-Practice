/// ///////////////////////////////

package InterviewBit;

import java.util.Arrays;

public class DistributeCandy {

    public static int minCandies(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1); // Step 1: give 1 candy to everyone

        // Step 2: left-to-right pass
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Step 3: right-to-left pass
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Step 4: sum the candies
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }
        return totalCandies;
    }

    public static void main(String[] args) {
        int[] ratings1 = {1, 2};
        int[] ratings2 = {1, 5, 2, 1};

        System.out.println(minCandies(ratings1)); // Output: 3
        System.out.println(minCandies(ratings2)); // Output: 7
    }
}
