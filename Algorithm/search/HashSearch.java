package Algorithm.search;

public class HashSearch {
    static String[] arr = {"pizza", "taco", "burger", "noodle"};
    static int[] hashArr = new int[arr.length * 2];

    public static void main(String[] args) {
        HashSearch hs = new HashSearch();
        System.out.println(hs.search(arr, 5));
    }

    int search(String[] arr, int x) {
        hasing(arr);
        return hashArr[x % 5];
    }

    void hasing(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (hashArr[i] == 0) {
                hashArr[i] = arr[i].length();
            } else {
                hashArr[i + 1] = arr[i].length();
            }
        }
    }
}
