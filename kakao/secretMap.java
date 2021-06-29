public class secretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};

        answer = new String[n];

        for (int i = 0; i < n; i++) {
            String num = "";

            for (int j = n - 1; j >= 0; j--) {

                if (((arr1[i] & (1 << j)) | (arr2[i] & (1 << j))) != 0) {
                    num += "#";
                } else {
                    num += " ";
                }
            }
            answer[i] = num;
        }
        return answer;
    }
}
