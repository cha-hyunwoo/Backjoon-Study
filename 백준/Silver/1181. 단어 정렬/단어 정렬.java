import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine()); // 단어의 개수

        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                // 원래 순서가 맞으면 음수를 줌
                return o1.compareTo(o2); // 자바 String의 기본 사전 비교 메서드
            }
            // 길이가 다르면
            return o1.length() - o2.length(); // 음수면 지금 순서가 맞음
        });
        // 0번 인덱스는 무조건 출력하니까
        sb.append(words[0]).append("\n");

        for (int i = 1; i < n; i++) {
            // 문자열은 == 말고 equals로 비교
            // 중복 제외
            if (words[i - 1].equals(words[i])) {
                continue;
            } else {
                sb.append(words[i]).append("\n");
            }
        }

        System.out.print(sb);
    }
}
