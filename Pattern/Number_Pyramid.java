package Pattern;
public class Number_Pyramid {
    public static void main(String[] args) {
        // char ch = 'A';
        
        int n = 6;
        
        for(int i=1; i<n; i++) {
            // Space
            for (int j=1; j<=n-i; j++) {
                System.out.print(" ");
            }

            int num = i;
            for(int k=1; k<=i; k++) {
                
                System.out.print(num + " ");

                num++;
            }

            num -= 2;

            for(int k=1; k<i; k++) {
                
                System.out.print(num + " ");

                num--;
            }

            System.out.println();
        }
    } 
}
