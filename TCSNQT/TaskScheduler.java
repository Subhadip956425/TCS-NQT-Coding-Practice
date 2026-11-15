/// ///////////////////////////////
/// https://leetcode.com/problems/task-scheduler/description/

package TCSNQT;

import java.util.*;

class TaskScheduler {

    public static int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        // Count frequency
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        // Sort frequencies
        Arrays.sort(freq);

        int maxFreq = freq[25];
        int maxCount = 0;

        // Count how many tasks have max frequency
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == maxFreq) maxCount++;
            else break;
        }

        int result = (maxFreq - 1) * (n + 1) + maxCount;

        return Math.max(tasks.length, result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nTasks = sc.nextInt();
        char[] tasks = new char[nTasks];

        for (int i = 0; i < nTasks; i++) {
            tasks[i] = sc.next().charAt(0);
        }

        int n = sc.nextInt();

        System.out.println(leastInterval(tasks, n));

        sc.close();
    }
}