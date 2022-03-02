package leetcode.string;

public class leetcode_392 {
    public static void main(String[] args) {
        leetcode_392 leetcode = new leetcode_392();
        System.out.println(leetcode.isSubsequence("b", "abc"));
    }

    // Time Complexity : O(N)
    // Space Complexity : O(N)
    public boolean isSubsequence(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        int j = 0;
        for (int i = 0; j < charS.length && i < charT.length; i++)
            if (charS[j] == charT[i]) j++;
        return j == charS.length;
    }
}
