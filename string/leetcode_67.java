package string;

public class leetcode_67 {
    public static void main(String[] args) {
        leetcode_67 lc = new leetcode_67();
        System.out.println(lc.addBinary("11", "1"));
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, sum = 0;
        while (i >= 0 || j >= 0) {
            sum = sum / 2;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
        }
        if (sum / 2 != 0) sb.append(1);
        return sb.reverse().toString();
    }
}
