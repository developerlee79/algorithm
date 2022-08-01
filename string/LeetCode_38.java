package string;

public class LeetCode_38 {
    public static void main(String[] args) {
        LeetCode_38 leetcode = new LeetCode_38();
        System.out.println(leetcode.countAndSay(7));
    }

    /**
     * @param n positive integer
     * @return nth term of the count-and-say sequence like this:
     *         1: 1
     *         2: 11
     *         3: 21
     *         4: 2111  ...
     *
     * Solution - Brute force
     * Time Complexity : O(N^2)
     * Space Complexity : O(N)
     *
     * Start with initialize string "1" and get count-and-say sequence in every loop until 1 -> n.
     * Parse previous say and convert to count-and-say sequence.
     */
    public String countAndSay(int n) {
        String say = "1";

        for (int i = 1; i < n; i++) {
            say = getCount(say);
        }

        return say;
    }

    private String getCount(String prevSay) {
        StringBuilder builder = new StringBuilder();

        char c = prevSay.charAt(0);
        int count = 1;
        for (int i = 1; i < prevSay.length(); i++) {
            if (prevSay.charAt(i) == c) {
                count++;
            } else {
                builder.append(count);
                builder.append(c);
                c = prevSay.charAt(i);
                count = 1;
            }
        }
        builder.append(count);
        builder.append(c);

        return builder.toString();
    }
}
