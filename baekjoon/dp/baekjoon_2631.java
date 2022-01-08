package baekjoon.dp;

import java.util.ArrayList;

public class baekjoon_2631 {
    public static void main(String[] args) {
        baekjoon_2631 bk = new baekjoon_2631();
        int[] arr = {3, 7, 5, 2, 6, 1, 4};
        System.out.println(bk.lining(arr));
    }

    int lining(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : arr) {
            if (list.size() == 0 || list.get(list.size() - 1) < num) {
                list.add(num);
            } else {
                int i = 0;
                int j = list.size() - 1;

                while (i < j) {
                    int mid = (i + j) / 2;
                    j = (list.get(mid) < num) ? mid + 1  : mid;
                }

                list.set(j, num);
            }
        }

        return arr.length - list.size();
    }
}
