package Array;

public class SumOnlyIntegers {
    public static void main(String[] args) {
        String[] arr = {"1", "2", "4","%", "g", "&", "0", "+", "@", "!", "abc"};

        int sum = 0;

        for(String str : arr) {
            try {
                int num = Integer.parseInt(str);
                sum += num;
            } catch (NumberFormatException e) {

            }
        }

        System.out.println("Sum is: " + sum);
    }
}
