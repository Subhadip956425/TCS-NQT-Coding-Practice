package BitManipulation;

public class MissingNumberFinder {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int missing = n; // start with n because indices are 0..n-1
        for (int i = 0; i < n; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

//    public int missingNumber(int[] nums) {
//        int n = nums.length;
//        int total = n * (n + 1) / 2;
//        int sum = 0;
//
//        for (int num : nums) {
//            sum += num;
//        }
//
//        return total - sum;
//    }

    public static void main(String[] args) {
        MissingNumberFinder solver = new MissingNumberFinder();

        int[] nums1 = {3,0,1};
        int[] nums2 = {0,1};
        int[] nums3 = {9,6,4,2,3,5,7,0,1};

        System.out.println(solver.missingNumber(nums1)); // 2
        System.out.println(solver.missingNumber(nums2)); // 2
        System.out.println(solver.missingNumber(nums3)); // 8
    }
}
