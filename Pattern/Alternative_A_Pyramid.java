package Pattern;
public class Alternative_A_Pyramid {
    public static void main(String[] args) {
        
        int num = 5;

        for (int i=1; i<=num; i++) {

            for(int j=i; j<num; j++) {
                System.out.print(" ");
            }

            for(int k=1; k<=i; k++) {
                if (k % 2 == 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("A ");
                }
            }
            System.out.println();
        }
    }
}
