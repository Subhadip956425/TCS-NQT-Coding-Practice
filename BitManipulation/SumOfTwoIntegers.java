/// //////////////////////////////

package BitManipulation;

public class SumOfTwoIntegers {
    
    public int getSum(int a, int b) {
        while (b != 0) {
            int sum = a ^ b;       // sum without carry
            int carry = (a & b) << 1; // carry
            a = sum;
            b = carry;
        }
        return a;
    }

    public static void main(String[] args) {
        SumOfTwoIntegers solver = new SumOfTwoIntegers();
        System.out.println(solver.getSum(1, 2));  // Output: 3
        System.out.println(solver.getSum(2, 3));  // Output: 5
        System.out.println(solver.getSum(-4, 5)); // Output: 1
    }
}
