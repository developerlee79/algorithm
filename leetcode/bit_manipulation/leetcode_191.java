package bit_manipulation;

public class leetcode_191 {
    public static void main(String[] args) {
        leetcode_191 lc = new leetcode_191();
        System.out.println(lc.hammingWeight(00000000000000000000000000001011));
    }

    // Solution - Bit manipulation
    // Time Complexity : O(N)
    // Space Complexity : O(1)
    // Use n - 1 to count bit of n
    // At binary, n - 1 is the same as removing the last bit of n
    // Therefore we can use &(And) operator to remove one bit from n
    // After removing every bit from n, it's gonna be 0 - so loop ended and get count.
    public int hammingWeight(int n) {
        int cnt = 0;

        while (n != 0) {
            n &= n - 1;
            cnt++;
        }

        return cnt;
    }
}
