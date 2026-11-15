package Number;

public class Fibonacci_Series {
    public static void main(String[] args) {
        int num = 10;
        int a = 0, b = 1;
        
        for(int i=1; i<=num; i++) {
            System.out.print(a + " ");

            int temp = b;
            b = a + b;
            a = temp;
    }
    }
}
