/////////////////////////////////////////

package BitManipulation;

public class CountingBits {
    
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        
        return ans;
    }


//    public int[] countBits(int n) {
//        int[] ans = new int[n + 1];
//        for (int x = 1; x <= n; ++x) {
//            ans[x] = ans[x & (x - 1)] + 1;
//        }
//        return ans;
//    }

    public static void main(String[] args) {
        CountingBits solution = new CountingBits();
        
        int n1 = 2;
        int n2 = 5;
        
        int[] result1 = solution.countBits(n1);
        int[] result2 = solution.countBits(n2);
        
        System.out.print("n = " + n1 + " → ");
        for (int x : result1) System.out.print(x + " ");
        System.out.println();
        
        System.out.print("n = " + n2 + " → ");
        for (int x : result2) System.out.print(x + " ");
        System.out.println();
    }
}
