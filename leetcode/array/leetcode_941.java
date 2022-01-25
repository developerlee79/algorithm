package leetcode.array;

public class leetcode_941 {
    public static void main(String[] args) {
        leetcode_941 lc = new leetcode_941();
        int[] arr = {0, 2, 3, 4, 5, 2, 1, 0};
        System.out.println(lc.validMountainArray(arr));
    }

    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) return false;

        int start = 0, end = arr.length - 1;

        while (start < end) {
            if (arr[start + 1] > arr[start]) {
                start++;
            } else if (arr[end - 1] > arr[end]) {
                end--;
            } else {
                break;
            }
        }
        return start != 0 && end != arr.length - 1 && start == end;
    }
}
