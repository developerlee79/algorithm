package kakao;

public class Kakao_StringCompression {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        for (int len = 1; len < s.length(); ++len) {
            StringBuilder compressed = new StringBuilder();
            String target = "";
            StringBuilder current;
            int cnt = 1;

            for (int i = 0; i < len; ++i) {
                target += s.charAt(i);
            }

            for (int i = len; i < s.length(); i += len) {
                current = new StringBuilder();
                for (int j = i; j < i + len; ++j) {
                    if (j >= s.length()) break;
                    current.append(s.charAt(j));
                }

                if (target.equals(current.toString())) {
                    cnt++;
                } else {
                    if (cnt > 1) {
                        compressed.append(cnt).append(target);
                    } else {
                        compressed.append(target);
                    }
                    cnt = 1;
                    target = current.toString();
                }
            }

            if (cnt > 1) {
                compressed.append(cnt).append(target);
            } else {
                compressed.append(target);
            }

            int length = compressed.length();
            answer = Math.min(answer, length);
        }

        if (answer == Integer.MAX_VALUE) answer = 1;

        return answer;
    }
}
