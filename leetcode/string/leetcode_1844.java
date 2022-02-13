package leetcode.string;

public class leetcode_1844 {
    public static void main(String[] args) {
        leetcode_1844 lc = new leetcode_1844();
        System.out.println(lc.replaceDigits("a1c1e1"));
    }

    public String replaceDigits(String s) {
        StringBuilder sb = new StringBuilder();

        char tmp = 0;
        for (char c : s.toCharArray()) {
            if (sb.length() % 2 == 0) {
                sb.append(c);
                tmp = c;
            } else {
                sb.append((char) (tmp + Character.getNumericValue(c)));
            }
        }

        return sb.toString();
    }

    public String replaceDigits2(String s) {
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i += 2) {
            arr[i] = (char) (arr[i - 1] + arr[i] - '0');
        }
        return String.valueOf(arr);
    }
}
