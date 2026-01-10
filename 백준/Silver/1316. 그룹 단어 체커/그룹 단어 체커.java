import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 단어의 개수


        int count = n; // 그룹 단어 체크 변수
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[26]; // 알파벳이 나왔었는지 체크
            String word = br.readLine();
            int prev = 0; // 이전 문자 아스키 코드 저장

            for (int j = 0; j < word.length(); j++) {
                int cur = word.charAt(j);
                if (cur != prev) {
                    if (!visited[cur - 'a']) {
                        visited[cur - 'a'] = true;
                        prev = cur; // 현재 문자로 갱신
                    } else { // 알파벳이 바꼇는데 이미 true이면
                        count--;
                        break;
                    }
                }
            }
        }
        System.out.print(count);
    }
}
