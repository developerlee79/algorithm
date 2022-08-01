package string;

public class leetcode_520 {
    public static void main(String[] args) {
        leetcode_520 lc = new leetcode_520();
        System.out.println(lc.detectCapitalUse("Leetcode"));
    }

    public boolean detectCapitalUse(String word) {
        if (word.length() < 2) return true;

        char[] chars = word.toCharArray();
        boolean[] boolArr = new boolean[3];
        boolArr[0] = chars[0] - 'a' > 0;

        for (int i = 1; i < chars.length; i++) {
            char ch = chars[i];
            int ac = ch - 'a';

            if (!boolArr[1])
                boolArr[1] = ac < 0;
            if (!boolArr[2])
                boolArr[2] = ac >= 0;

            if (boolArr[0] && ac < 0)
                return false;
            if (boolArr[1] && boolArr[2])
                return false;
        }

        return true;
    }
}
