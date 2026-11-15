package TCS_NQT_Concept;

public class SweetSeventeen {
    public static int getValue(char ch) {
        ch = Character.toUpperCase(ch);

        if (ch >= '0' && ch <= '9')  {
            return ch - '0';
        } else {
            return ch - 'A' + 10;
        }
    }

    public static int base17ToDecimal(String input) {
        int result = 0, power = 1;

        for(int i=input.length() - 1; i>=0; i--) {
            int value = getValue(input.charAt(i));
            result += value * power;
            power *= 17;
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "23GF";
        int decimal = base17ToDecimal(input);
        System.out.println("Decimal value: " + decimal);
    }
}
