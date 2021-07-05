package baekjoon;

public class baekjoon_2748 {
    public static void main(String[] args) {
        baekjoon_2748 answer = new baekjoon_2748();

        System.out.println(answer.getFibonacci(6));
    }

    public int getFibonacci(int n) {
        int[] tmp = new int[2];

        tmp[1] = 1;

        for (int i = 0; i < n-1; i++) {
            int tmpNum = tmp[0] + tmp[1];

            tmp[0] = tmp[1];
            tmp[1] = tmpNum;
        }

        return tmp[1];
    }
}
