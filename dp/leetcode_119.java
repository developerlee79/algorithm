package dp;

import java.util.ArrayList;
import java.util.List;

public class leetcode_119 {
    public static void main(String[] args) {
        leetcode_119 lc = new leetcode_119();
        System.out.println(lc.getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < rowIndex + 1; i++) {
            result.add(getLine(i));
        }

        return result.get(rowIndex);
    }

    List<Integer> getLine(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j >= 1; j--) {
                int tmp = list.get(j - 1) + list.get(j);
                list.set(j, tmp);
            }
            list.add(1);
        }
        return list;
    }
}
