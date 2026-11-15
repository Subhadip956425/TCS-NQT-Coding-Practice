package TCS_NQT_Concept;

import java.util.*;

public class SundayCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String startDay = sc.next().toLowerCase(); // e.g., "mon"
        int n = sc.nextInt();                      // e.g., 13

        // Optimal day lookup using HashMap
        Map<String, Integer> dayIndexMap = new HashMap<>();
        dayIndexMap.put("sun", 0);
        dayIndexMap.put("mon", 1);
        dayIndexMap.put("tue", 2);
        dayIndexMap.put("wed", 3);
        dayIndexMap.put("thu", 4);
        dayIndexMap.put("fri", 5);
        dayIndexMap.put("sat", 6);

        // Validate input
        if (!dayIndexMap.containsKey(startDay)) {
            System.out.println("Invalid day input");
            return;
        }

        int startIndex = dayIndexMap.get(startDay);

        // Calculate how many days till first Sunday
        int daysUntilFirstSunday = (7 - startIndex) % 7;

        // If first Sunday is beyond total days, then 0 Sundays
        if (daysUntilFirstSunday >= n) {
            System.out.println(0);
            return;
        }

        int remainingDays = n - daysUntilFirstSunday;
        int sundayCount = 1 + (remainingDays - 1) / 7;

        System.out.println(sundayCount);
    }
}
