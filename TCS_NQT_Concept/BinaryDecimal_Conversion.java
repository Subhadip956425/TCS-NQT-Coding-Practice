package TCS_NQT_Concept;

public class BinaryDecimal_Conversion {
    public static void main(String[] args) {
        int decimal = 10;
        String binary = decimalToBinary(decimal);
        System.out.println("Binary of " + decimal + " = " + binary);

        int backToDecimal = binaryToDecimal(binary);
        System.out.println("Decimal of " + binary + " = " + backToDecimal);
    }

    public static String decimalToBinary(int n) {
        if (n == 0) return "0";
        StringBuilder binary = new StringBuilder();
        while (n > 0) {
            int rem = n % 2;
            binary.insert(0, rem);
            n = n / 2;
        }
        return binary.toString();
    }

    public static int binaryToDecimal(String binary) {
        int result = 0;
        int power = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            int bit = binary.charAt(i) - '0';
            result += bit * Math.pow(2, power);
            power++;
        }
        return result;
    }
}


// Using Bit wise Operator

// public class Main {
//     public static void main(String[] args) {
//         int decimal = 10;
//         String binary = decimalToBinary(decimal);
//         System.out.println("Binary of " + decimal + " = " + binary);

//         int convertedBack = binaryToDecimal(binary);
//         System.out.println("Decimal of " + binary + " = " + convertedBack);
//     }

//     public static String decimalToBinary(int n) {
//         if (n == 0) return "0";
//         StringBuilder binary = new StringBuilder();
//         while (n > 0) {
//             binary.insert(0, (n & 1));
//             n >>= 1;
//         }
//         return binary.toString();
//     }

//     public static int binaryToDecimal(String binary) {
//         int result = 0;
//         for (int i = 0; i < binary.length(); i++) {
//             result = (result << 1) + (binary.charAt(i) - '0');
//         }
//         return result;
//     }
// }

