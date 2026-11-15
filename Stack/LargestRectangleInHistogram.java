/// /////////////////////////////////////////
/// LeetCode 84. Largest Rectangle in Histogram

package Stack;

import java.util.*;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }

    // Main method for testing
    public static void main(String[] args) {
        LargestRectangleInHistogram solution = new LargestRectangleInHistogram();

        int[] h1 = {2,1,5,6,2,3};
        System.out.println(solution.largestRectangleArea(h1)); // Output: 10

        int[] h2 = {2,4};
        System.out.println(solution.largestRectangleArea(h2)); // Output: 4
    }
}
