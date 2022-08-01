package bit_manipulation;

public class leetcode_2235 {
    public static void main(String[] args) {
        leetcode_2235 leetcode = new leetcode_2235();
        System.out.println(leetcode.sum(5, 10));
    }

    // Solution - Bit manipulation
    // Time Complexity : O(1)
    // Space Complexity : O(1)
    // Well... I know this problem is just be used to become familiar with the platform for new users.
    // But it can be solved as a bit manipulation problem, just like the operation of an OS.
    // First, AND(&) two numbers. and if there a bit with both bits equal to 1, then multiply by 2[0010] to makes it rounded up.
    // Second, XOR(^) two numbers. The XOR operator performs addition excluding rounding because when bits 0-1 then 1 and if 0-0 then 0.
    // And combine two numbers to complete the addition with bit manipulation.
    //
    // Example - sum(3, 10)
    //
    // 1. num1 AND num2
    // [0011] & [1010] = [0010]
    //
    // 2. op1 * 2
    // [0011] * [0010] = [0100]
    //
    // 3. num1 XOR num2
    // [0011] & [1010] = [1001]
    //
    // 4. op2 + op3
    // [0100] + [1001] = [1101]
    //
    // Therefore [8 + 4 + 0 + 1] = 13!
    public int sum(int num1, int num2) {
        return (num1 & num2) * 2 + (num1 ^ num2);
    }
}
