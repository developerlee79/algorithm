package baekjoon.string;

public class baekjoon_1157 {
    public static void main(String[] args) {
        baekjoon_1157 bj = new baekjoon_1157();
        System.out.println(bj.mostAlphabet("zZa"));
    }

    char mostAlphabet(String str) {
        int[] arr = new int[26];

        for (int i = 0; i < str.length(); i++) {
            if ('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
                arr[str.charAt(i) - 97]++;
            } else {
                arr[str.charAt(i) - 65]++;
            }
        }

        int max = -1;
        char ch ='?';
        for (int i = 0; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
                ch = (char) (i + 65);
            } else if (arr[i] == max) {
                ch = '?';
            }
        }

        return ch;
    }
}
