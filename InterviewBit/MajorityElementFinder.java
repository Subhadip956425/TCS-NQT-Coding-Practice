/// ///////////////////////////

package InterviewBit;

import java.util.Arrays;
import java.util.List;

public class MajorityElementFinder {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2, 1, 2);
        System.out.println(majorityElement(nums)); // Output: 2
    }

    private static int majorityElement(List<Integer> list) {
        int ans = list.get(0);
        int count = 1;

        for (int i=1; i<list.size(); i++) {
            if (count == 0) {
                ans = list.get(i);
                count = 1;
            } else if (ans == list.get(i)) {
                count++;
            } else {
                count--;
            }
        }
        return ans;
    }
}
