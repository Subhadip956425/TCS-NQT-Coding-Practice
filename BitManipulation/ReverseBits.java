/// ///////////////////////////////////////////////////////////

package BitManipulation;

public class ReverseBits {
    
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;        // make room for next bit
            result |= (n & 1);   // add last bit of n
            n >>>= 1;            // logical right shift (unsigned)
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseBits solver = new ReverseBits();
        
        int n1 = 43261596;
        System.out.println("Reversed: " + solver.reverseBits(n1)); // 964176192
        
        int n2 = 2147483644;
        System.out.println("Reversed: " + solver.reverseBits(n2)); // 1073741822
    }
}
