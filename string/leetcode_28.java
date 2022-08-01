package string;

public class leetcode_28 {
    public static void main(String[] args) {
        leetcode_28 lc = new leetcode_28();
        System.out.println(lc.strStr("hello", "ll"));
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        if (haystack.length() == 0)
            return -1;


        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() > haystack.length()) break;

            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j))
                    break;
                if (j == needle.length() - 1)
                    return i;
            }
        }

        return -1;
    }
}
