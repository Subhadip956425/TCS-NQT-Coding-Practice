package TCS_NQT_Concept;

import java.util.Scanner;

public class SoberWalk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int x=0, y=0;
        int distance = 10;

        for(int i=0; i<n; i++) {
            switch (i % 4) {
                case 0:
                    x += distance;
                    break;
                case 1:
                    y += distance;    
                    break;
                case 2:
                    x -= distance;    
                    break;
                case 3:
                    y += distance;    
                    break;
            
                default:
                    break;
            }
            distance += 10;
        }
        System.out.println(x + " " + y);
    }    
}
