package string;

import java.util.LinkedList;
import java.util.List;

public class leetcode_412 {
    public static void main(String[] args) {
        leetcode_412 leetcode = new leetcode_412();
        System.out.println(leetcode.fizzBuzz(15));
    }

    // Solution - Brute force
    // Time Complexity : O(N)
    // Space Complexity : O(1)
    public List<String> fizzBuzz(int n) {
        String fizzBuzz = "FizzBuzz";
        List<String> result = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                result.add(fizzBuzz);
            else if (i % 3 == 0)
                result.add(fizzBuzz.substring(0, 4));
            else if (i % 5 == 0)
                result.add(fizzBuzz.substring(4, 8));
            else
                result.add(String.valueOf(i));
        }

        return result;
    }
}
