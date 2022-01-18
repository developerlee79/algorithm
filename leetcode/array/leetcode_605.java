package leetcode.array;

public class leetcode_605 {
    public static void main(String[] args) {
        leetcode_605 lc = new leetcode_605();
        int[] flowerbed = {1, 0, 0, 0, 1};
        System.out.println(lc.canPlaceFlowers(flowerbed, 1));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;

        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                n--;
            }
        }

        return n == 0;
    }
}
