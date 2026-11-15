package Number;


// A Strong Number is a number for which the sum of the factorial of its digits equals the number itself.

// Example:
// 145 is a Strong Number because
// 1! + 4! + 5! = 1 + 24 + 120 = 145

public class StrongNumberCheck {

    // Method to calculate factorial
    public static int factorial(int n) {
        int fact = 1;
        for(int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // Method to check strong number
    public static boolean isStrongNumber(int num) {
        int sum = 0;
        int temp = num;

        while(temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }

        return sum == num;
    }

    public static void main(String[] args) {
        int number = 145;  // you can test with any number

        if(isStrongNumber(number)) {
            System.out.println(number + " is a Strong Number.");
        } else {
            System.out.println(number + " is NOT a Strong Number.");
        }
    }
}

