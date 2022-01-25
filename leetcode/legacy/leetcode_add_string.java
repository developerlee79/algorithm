public class leetcode_add_string {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int sum = 0;
        StringBuilder builder = new StringBuilder();

        while (i >= 0 || j >= 0 || sum > 0) {
            if (i >= 0) {
                sum += (num1.charAt(i) - '0');
                i--;
            }
            if (j >= 0) {
                sum += (num2.charAt(j) - '0');
                j--;
            }

            builder.append(sum % 10);
            sum = sum > 9 ? sum / 10 : 0;
        }

        return builder.reverse().toString();
    }
}
