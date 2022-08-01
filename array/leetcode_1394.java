package array;

import java.util.Arrays;

public class leetcode_1394 {
    public static void main(String[] args) {
        leetcode_1394 lc = new leetcode_1394();
        int[] arr = {4, 3, 2, 2, 4, 1, 3, 4, 3};
        System.out.println(lc.findLucky(arr));
    }

    public int findLucky(int[] arr) {
        int[] cntArr = new int[Arrays.stream(arr).max().getAsInt() + 1];

        for (int i : arr) {
            cntArr[i]++;
        }

        for (int i = cntArr.length - 1; i > 0; i--) {
            if (cntArr[i] == i) return i;
        }

        return -1;
    }
}
