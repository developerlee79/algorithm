import java.util.Arrays;
import java.util.stream.Stream;

public class leetcode_roman_to_integer {
    public static void main(String[] args) {
        System.out.println(romanToInt("IX"));
    }
    static int romanToInt(String s) {
        String[] arr = new String[s.length()];
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.substring(i, i + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case "I":
                    result += 1;
                    break;
                case "V":
                    result += 5;
                    break;
                case "X":
                    result += 10;
                    break;
                case "L":
                    result += 50;
                    break;
                case "C":
                    result += 100;
                    break;
                case "D":
                    result += 500;
                    break;
                case "M":
                    result += 1000;
                    break;
            }

            if (i >= 1) {
                if (arr[i].equals("V") && arr[i - 1].equals("I") || arr[i].equals("X") && arr[i - 1].equals("I")) {
                    result -= 2;
                } else if (arr[i].equals("L") && arr[i - 1].equals("X") || arr[i].equals("C") && arr[i - 1].equals("X")) {
                    result -= 20;
                } else if (arr[i].equals("D") && arr[i - 1].equals("C") || arr[i].equals("M") && arr[i - 1].equals("C")) {
                    result -= 200;
                }
            }
        }

        return result;
    }
}
