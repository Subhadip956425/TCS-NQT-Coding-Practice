/// ///////////////////////////////

package Revise;

import java.util.Arrays;

public class ProductExceptSelf_238 {
    
    public static void main(String[] args) {
        
        int[] arr = {1, 2, 3, 4};

        int[] result = product(arr);

        System.out.println("Output: " + Arrays.toString(result));
    }

    static int[] product(int[] arr) {

        int n = arr.length;
        int[] ans = new int[n];

        ans[0] = 1;
        for(int i=1; i<n; i++) {
            ans[i] = ans[i-1] * arr[i-1];
        }

        int rightProduct = 1;
        for(int i=n-1; i>=0; i--) {
            ans[i] = ans[i] * rightProduct;
            rightProduct *= arr[i];
        }

        return ans;
    }
}
