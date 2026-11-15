package TCS_NQT_Concept;

public class GreaterThanPrevious {
    public static void main(String[] args) {
        int[] arr = {7, 4, 8, 2, 9};
        int result = countGreaterElements(arr);
        System.out.println(result);  // Output: 3
    }

    public static int countGreaterElements(int[] arr) {
        int count = 1;  // First element is always counted
        int maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxSoFar) {
                count++;
                maxSoFar = arr[i];  // Update the maximum
            }
        }
        return count;
    }
}
