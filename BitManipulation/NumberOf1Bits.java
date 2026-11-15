package BitManipulation;

public class NumberOf1Bits {
    
    // Method to count the number of 1 bits (Hamming Weight)
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1); // removes the lowest set bit
            count++;
        }
        return count;
    }

    // Main method for testing
    public static void main(String[] args) {
        NumberOf1Bits solution = new NumberOf1Bits();

        int n1 = 11; // binary: 1011 → 3 set bits
        int n2 = 128; // binary: 10000000 → 1 set bit
        int n3 = 2147483645; // binary: 1111111111111111111111111111101 → 30 set bits

        System.out.println("Hamming Weight of " + n1 + " = " + solution.hammingWeight(n1));
        System.out.println("Hamming Weight of " + n2 + " = " + solution.hammingWeight(n2));
        System.out.println("Hamming Weight of " + n3 + " = " + solution.hammingWeight(n3));
    }
}


// class Solution {
//     public int hammingWeight(int n) {
//         int ans = 0;
//         while(n>=1) {
//             if(n%2==1) ans++;
//             n/=2;
//         }
//         return ans;
//     }
// }
