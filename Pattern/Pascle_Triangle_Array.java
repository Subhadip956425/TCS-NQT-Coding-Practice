/// ///////////////////////


package Pattern;
public class Pascle_Triangle_Array {
    public static void main(String[] args) {
        // char ch = 'A';
        
        int n = 5;
        
        for(int i=0; i<n; i++) {
            // Space
            for (int j=0; j<n-i; j++) {
                System.out.print(" ");
            }

            int num = 1;
            for(int k=0; k<=i; k++) {
                
                System.out.print(num + " ");

                num = num * (i-k) /(k+1);

            }

            System.out.println();
        }
    } 
}
