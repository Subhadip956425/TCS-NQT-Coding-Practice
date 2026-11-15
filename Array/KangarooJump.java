package Array;


//Mathematical Explanation
//
//After n jumps:
//
//Position of Kangaroo 1 = x1 + n * v1
//
//Position of Kangaroo 2 = x2 + n * v2
//
//They meet if:
//
//x1 + n*v1 = x2 + n*v2
//=> x1 - x2 = n*(v2 - v1)
//=> n = (x1 - x2) / (v2 - v1)
//
//
//✅ Conditions:
//
//n must be a non-negative integer.
//
//(x1 - x2) % (v2 - v1) == 0 → divisible.

import java.util.*;

public class KangarooJump {
    static String kangaroo(int x1, int v1, int x2, int v2) {
        if (v1 == v2) {
            return (x1 == x2) ? "YES" : "NO";
        }

        if ((x1 - x2) % (v2 - v1) == 0 && (x1 - x2) / (v2 - v1) >= 0) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int v1 = sc.nextInt();
        int x2 = sc.nextInt();
        int v2 = sc.nextInt();

        System.out.println(kangaroo(x1, v1, x2, v2));
        sc.close();
    }
}
