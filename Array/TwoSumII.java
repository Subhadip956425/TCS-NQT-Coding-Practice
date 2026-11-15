package Array;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // +1 because the problem expects 1-based indices
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;  // need bigger sum → move left pointer right
            } else {
                right--; // need smaller sum → move right pointer left
            }
        }

        return new int[]{-1, -1}; // just a fallback, but problem guarantees solution
    }

    public static void main(String[] args) {
        TwoSumII sol = new TwoSumII();

        int[] res1 = sol.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(res1[0] + ", " + res1[1]); // 1, 2

        int[] res2 = sol.twoSum(new int[]{2, 3, 4}, 6);
        System.out.println(res2[0] + ", " + res2[1]); // 1, 3

        int[] res3 = sol.twoSum(new int[]{-1, 0}, -1);
        System.out.println(res3[0] + ", " + res3[1]); // 1, 2
    }
}
