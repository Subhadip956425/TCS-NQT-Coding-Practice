//////////////////////////////////

package Number;
public class LCM {
    public static int calculate_GCD(int a, int b) {

        while(b != 0) {
            int temp = b;
            b = a % b ;
            a = temp;
        }

        return a;
    }

    static int LCM_of_Array(int[] arr) {
        int result = arr[0];
        for(int i=1; i<arr.length; i++) {
            result = (result * arr[i]) / calculate_GCD(result, arr[i]);
        }

        return result;
    }
    public static void main(String[] args) {
        int num1 = 16, num2 = 8;

        int[] arr = {12, 18};

        System.out.println(LCM_of_Array(arr));
    }
}
