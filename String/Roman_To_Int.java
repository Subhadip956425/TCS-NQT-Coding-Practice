package String;

public class Roman_To_Int {

    public static void main(String[] args) {
        String roman1 = "MCMXCIV"; // 1994
        String roman2 = "LVIII";   // 58
        String roman3 = "IX";      // 9

        System.out.println(roman1 + " -> " + romanToInt(roman1));
        System.out.println(roman2 + " -> " + romanToInt(roman2));
        System.out.println(roman3 + " -> " + romanToInt(roman3));
    }

    public static int romanToInt(String s) {
        int[] values = new int[128];

        values['I'] = 1;
        values['V'] = 5;
        values['X'] = 10;
        values['L'] = 50;
        values['C'] = 100;
        values['D'] = 500;
        values['M'] = 1000;

        int total = 0;
        int prevValue = 0;

        for (int i=s.length()-1; i>=0; i--) {
            int val = values[s.charAt(i)];

            if (val < prevValue) {
                total -= val;
            } else {
                total += val;
            }

            prevValue = val;
        }
        return total;
    }
}
