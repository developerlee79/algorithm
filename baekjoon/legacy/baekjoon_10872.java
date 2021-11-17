package baekjoon;

public class baekjoon_10872 {
    public static void main(String[] args) {
        System.out.println(getFactorial(10));
    }

    static int factorial = 1;

    static int getFactorial(int num) {
        if (num == 1) return factorial;
        factorial *= num;
        return getFactorial(num - 1);
    }
}
