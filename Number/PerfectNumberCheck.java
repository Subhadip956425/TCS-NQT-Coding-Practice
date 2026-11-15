package Number;

public class PerfectNumberCheck {
    public static void main(String[] args) {
        int num = 28;
        int sum = 0;

        // Find divisors
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        // Check if sum of divisors equals the number
        if (sum == num) {
            System.out.println(num + " is a Perfect Number");
        } else {
            System.out.println(num + " is NOT a Perfect Number");
        }
    }
}
