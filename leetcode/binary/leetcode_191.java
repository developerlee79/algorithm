package leetcode.binary;

public class leetcode_191 {
    public static void main(String[] args) {
        leetcode_191 lc = new leetcode_191();
        System.out.println(lc.hammingWeight(00000000000000000000000000001011));
    }

    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
            n = n & (n - 1);
            count++;
        }

        return count;
    }
}
