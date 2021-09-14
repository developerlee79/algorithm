package Algorithm.search;

public class LinearSearch {
    static int[] arr = {1, 2, 3, 4, 5};

    public static void main(String[] args) {
        LinearSearch ls = new LinearSearch();
        System.out.println(ls.search(arr, 5));
    }

    int search(int[] arr, int x) {
        for (int j : arr) {
            if (j == x) return j;
        }

        return -1;
    }
}
