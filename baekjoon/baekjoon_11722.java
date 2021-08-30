package baekjoon.newal;

import java.util.ArrayList;

public class baekjoon_11722 {
    int[] arr = {50, 40, 30, 20, 20, 50};

    public static void main(String[] args) {
        baekjoon_11722 bj = new baekjoon_11722();
        System.out.println(bj.minusArr(bj.arr));
    }

    ArrayList<Integer> arrayList = new ArrayList<>();

    int minusArr(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (!arrayList.contains(arr[i]) && !arrayList.contains(arr[i + 1])) {
                arrayList.add(Math.max(arr[i], arr[i + 1]));
            }
        }

        if (!arrayList.contains(arr[arr.length - 1]) && arrayList.get(arrayList.size() - 1) > arr[arr.length - 1]) {
            arrayList.add(arr[arr.length - 1]);
        }

        return arrayList.size();
    }
}
