/// ////////////////////////
/// https://leetcode.com/problems/number-of-recent-calls/description/



package TCSNQT.Repeat;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class RecentCallCounter {

    private Queue<Integer> queue = new LinkedList<>();

    public int ping(int t) {
        queue.offer(t);

        while (!queue.isEmpty() && queue.peek() < t - 3000) { //////////
            queue.poll();
        }

        return queue.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        RecentCallCounter counter = new RecentCallCounter();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            System.out.println(counter.ping(t));
        }

        sc.close();
    }
}


//package TCSNQT;
//
//import java.util.*;
//
//public class RecentCallCounter {
//
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        Queue<Integer> queue = new LinkedList<>();
//
//        int n = sc.nextInt(); // number of ping calls
//
//        for (int i = 0; i < n; i++) {
//            int t = sc.nextInt();
//
//            // Add current request
//            queue.offer(t);
//
//            // Remove outdated requests
//            while (!queue.isEmpty() && queue.peek() < t - 3000) {
//                queue.poll();
//            }
//
//            // Print current count
//            System.out.println(queue.size());
//        }
//
//        sc.close();
//    }
//}