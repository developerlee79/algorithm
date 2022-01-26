package Cote;

import java.util.ArrayList;
import java.util.List;

public class leetcode_reverse_integer {
    public static void main(String[] args) {
        leetcode_reverse_integer cd = new leetcode_reverse_integer();

        System.out.println(cd.reverse(-21474848));
    }

    public int reverse(int x) {
        int sign = (x >= 0) ? 1 : -1;
        x *= sign;
        List<Integer> nums = new ArrayList<>();
        Long result = new Long(0);

        while(x > 0) {
            result = (result * 10) + (x % 10);
            x /= 10;
        }

        if(result > Integer.MAX_VALUE) return 0;
        return result.intValue() * sign;
    }
}
