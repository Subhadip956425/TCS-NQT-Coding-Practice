package Array;

public class MinSubArrayLenSolution {

    static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int length = Integer.MAX_VALUE;

        for (int i=0; i<nums.length; i++) {
            sum += nums[i];

            while (target <= sum) {
                length = Math.min(length, (i-left+1));
                sum -= nums[left];
                left++;
            }
        }

        return length == Integer.MAX_VALUE ? 0 : length;
    }
    

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;

        int result = minSubArrayLen(target, nums);
        System.out.println("Minimum length of subarray: " + result);
    }
}
