package math;

import java.util.LinkedList;

public class leetcode_258 {
    public static void main(String[] args) {
        leetcode_258 lc = new leetcode_258();
        System.out.println(lc.addDigits(0));
    }

    // Solution - Math
    public int addDigits(int num) {
        if(num == 0) return 0;
        else if(num % 9 == 0) return 9;
        else return num % 9;
    }

    // Solution - Brute
    public int addDigitsBrute(int num) {
        String numStr = num + "";
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < numStr.length(); i++) {
            list.add(Integer.parseInt(numStr.substring(i, i + 1)));
        }

        int tmp = 0;
        while (true) {
            for (int i : list) {
                tmp += i;
            }

            if (tmp < 10) break;

            numStr = tmp + "";
            list.clear();
            tmp = 0;
            for (int i = 0; i < numStr.length(); i++) {
                list.add(Integer.parseInt(numStr.substring(i, i + 1)));
            }
        }

        return tmp;
    }
}
