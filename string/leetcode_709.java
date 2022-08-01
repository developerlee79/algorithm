package string;

public class leetcode_709 {
    public static void main(String[] args) {
        leetcode_709 lc = new leetcode_709();
        System.out.println(lc.toLowerCase("ABC"));
    }

    public String toLowerCase(String s) {
        char[] res = s.toCharArray();
        for (int i = 0; i < res.length; i++)
            if (res[i] >= 'A' && res[i] <= 'Z') res[i] += 32;
        return new String(res);
    }
}
