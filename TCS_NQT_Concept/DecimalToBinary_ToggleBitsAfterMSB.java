package TCS_NQT_Concept;

import java.util.Scanner;

public class DecimalToBinary_ToggleBitsAfterMSB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num= sc.nextInt();

        int temp = num;
        int bits = 0;

        while (temp > 0) {
            bits++;
            temp >>= 1;
        }

        int mask = (1 << bits) - 1; // (1 << 4) = 16 (1 << 4) - 1 = 15

        int res = num ^ mask;

        System.out.println(res);
    }
}
