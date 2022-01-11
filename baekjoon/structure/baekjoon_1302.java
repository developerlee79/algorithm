package baekjoon.structure;

import java.util.*;

public class baekjoon_1302 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfBooks = sc.nextInt();
        HashMap<String, Integer> bookMap = new HashMap<>(numberOfBooks);
        for (int i = 0; i < numberOfBooks; i++) {
            String tmp = sc.next();
            bookMap.put(tmp, bookMap.get(tmp) != null ? bookMap.get(tmp) + 1 : 1);
        }

        String maxBook = "";
        int cnt = 0;

        for (String key : bookMap.keySet()) {
            int tmp = bookMap.get(key);

            if (cnt == tmp && maxBook.compareTo(key) > 0) {
                maxBook = key;
            } else if (cnt < tmp) {
                cnt = tmp;
                maxBook = key;
            }
        }

        System.out.println(maxBook);
    }
}