public class baekjoon_1463 {
    public static void main(String[] args) {
        System.out.println(countIntegerToOne(10, 0));
    }

    static int countIntegerToOne(int n, int count) {
        if (n < 2) {
            return count;
        }
        return Math.min(countIntegerToOne(n / 2, count + 1 + (n % 2)), countIntegerToOne(n / 3, count + 1 + (n % 3)));
    }
}
