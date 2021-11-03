public class baekjoon_2960 {
    public static void main(String[] args) {
        isPrimeNumberCeive(100000);
    }

    static void isPrimeNumberCeive(int x) {
        int[] a = new int[x + 1];

        for (int i = 2; i < x; i++) {
            a[i] = i;
        }

        for (int i = 2; i <= x; i++) {
            if (a[i] == 0) continue;
            for (int j = i * 2; j <= x; j+= i)  {
                a[j] = 0;
            }
        }

        for (int i = 2; i <= x; i++) {
            if (a[i] != 0) System.out.println(a[i]);
        }
    }
}
