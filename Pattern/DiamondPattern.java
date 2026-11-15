package Pattern;
public class DiamondPattern {
    public static void main(String[] args) {
        
        int num = 5;

        //First half

        for (int i=1; i<=num; i++) {

            
            for (int j=i; j<num; j++) {
                System.out.print(" ");
            }

            for (int k=1; k<=i; k++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        // 2nd half

        for (int i=num; i>1; i--) {
            for (int j=num; j>=i; j--) {
                System.out.print(" ");
            }

            for (int k=i-1; k>=1; k--) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
}
