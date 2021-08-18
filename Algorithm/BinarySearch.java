package Algorithm;

public class BinarySearch {

    static int[] arr = {1, 2, 3, 4, 5, 6, 8};

    static int start = 0;
    static int end = arr.length;

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.binarySearch(8, start, end));
    }

    int binarySearch(int x, int start, int end) {
        int middle = (start + end) / 2;

        if (start >= arr.length)
            return -1;

        if (arr[middle] == x) return middle + 1;
        if (arr[middle] > x)
            end = middle - 1;
        if (arr[middle] < x)
            start = middle + 1;

        return binarySearch(x, start, end);
    }
}
