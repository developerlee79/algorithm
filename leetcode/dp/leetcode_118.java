package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class leetcode_118 {
    public static void main(String[] args) {
        leetcode_118 lc = new leetcode_118();
        System.out.println(lc.generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);
        if (numRows == 1) return result;

        List<Integer> secondRow = new ArrayList<>();
        secondRow.add(1);
        secondRow.add(1);
        result.add(secondRow);
        if (numRows == 2) return result;

       for (int i = 2; i < numRows; i++) {
           List<Integer> list = new ArrayList<>();

           list.add(1);
           for (int j = i - 1; j > 0; j--) {
               list.add(result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
           }
           list.add(1);

           result.add(list);
       }

       return result;
    }
}
