package leetcode.math;

public class leetcode_1185 {
    public static void main(String[] args) {
        leetcode_1185 leetcode = new leetcode_1185();
        System.out.println(leetcode.dayOfTheWeek(15, 8, 1993));
    }

    // Solution - Brute count & Zeller formula
    // Time Complexity : O(N)
    // Space Complexity : O(1)
    // Count all days between 1 Jan 1971 to given date. (with checked leap year)
    // days % 7 equal the week day of given date. (mod 7)
    public String dayOfTheWeek(int day, int month, int year) {
        String[] dayOfWeeks = {"Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday"};
        int[] dayCountOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int days = 0;
        for (int i = 1971; i < year; i++)
            days += ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0 ? 366 : 365);
        for (int i = 0; i < month - 1; i++)
            days += (i == 1 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) ? 29 : dayCountOfMonth[i];
        days += day;

        return dayOfWeeks[days % 7];
    }
}
