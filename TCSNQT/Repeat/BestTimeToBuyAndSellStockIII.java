// Need to Repeat
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/

package TCSNQT.Repeat;

import java.util.Scanner;

public class BestTimeToBuyAndSellStockIII {

    public static int maxProfit(int[] prices) {

        int buy1 = Integer.MAX_VALUE;
        int sell1 = 0;

        int buy2 = Integer.MAX_VALUE;
        int sell2 = 0;

        for (int price : prices) {

            buy1 = Math.min(buy1, price);      /////////////////
            sell1 = Math.max(sell1, price - buy1); //////////////

            buy2 = Math.min(buy2, price - sell1); /////////////
            sell2 = Math.max(sell2, price - buy2); /////////////
        }

        return sell2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int result = maxProfit(prices);

        System.out.println(result);

        sc.close();
    }


//    Optimized approach

//    class Solution
//{
//    // look into other solutions
//    public int maxProfit(int[] prices)
//    {
//        int k = 2;
//        int[] hold = new int[k + 1];
//        int[] sell = new int[k + 1];
//
//        for(int i = 0; i <= k; i++) hold[i] = Integer.MIN_VALUE;
//
//        for(int price: prices)
//        {
//            for(int i = 1; i <= k ; i++)
//            {
//                hold[i] = Math.max(hold[i], sell[i - 1] - price);
//                sell[i] = Math.max(sell[i], hold[i] + price);
//            }
//            //System.out.println(Arrays.toString(hold));
//            //System.out.println(Arrays.toString(sell));
//        }
//        return sell[k];
//    }
//}
}