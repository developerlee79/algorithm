package leetcode.math;

public class leetcode_762 {

    // Solution 1
    // Determine prime number with primality test
    // Time Complexity : O(NP)
    public int countPrimeSetBits(int left, int right) {
        int cnt = 0;

        for (int i = left; i <= right; i++) {
            if (isPrimeNumber(Integer.bitCount(i))) cnt++;
        }

        return cnt;
    }

    // Solution 2
    // Determine prime number with prime number array
    // The reason of prime number array length is only 20
    // because biggest bit count of left/right's max value is 19
    // Time Complexity : O(N)
    public int countPrimeSetBitsByPrimeNumSet(int left, int right) {
        boolean[] primeArr = {false, false, true, true, false, true, false, true, false,
                false, false, true, false, true, false, false, false, true, false, true,
                false, false, false, true};
        int cnt = 0;

        for (int i = left; i <= right; i++) {
            if (primeArr[Integer.bitCount(i)]) cnt++;
        }

        return cnt;
    }

    private static boolean isPrimeNumber(int i) {
        int f = 2, j = i;
        while (i > 1) {
            if (i % f == 0)
                i /= f;
            else
                f++;
        }
        return f == j;
    }
}
