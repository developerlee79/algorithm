package string;

public class leetcode_389 {
    public static void main(String[] args) {
        leetcode_389 lc = new leetcode_389();
        System.out.println(lc.findTheDifference("a", "aa"));
    }

    public char findTheDifference(String s, String t) {
        char a, b;
        a = b = 'a';

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            a += arr1[i];
            b += arr2[i];
        }

        return (char) (b + t.charAt(arr2.length - 1) - a);
    }
}
