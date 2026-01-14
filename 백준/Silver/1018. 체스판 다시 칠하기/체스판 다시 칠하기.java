import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 보드의 세로
        int m = Integer.parseInt(st.nextToken()); // 보드의 가로

        boolean[][] chs = new boolean[n][m];

        // 전체 보드에서 흰색이면 true 검은색이면 false
        for (int i = 0; i < n; i++) {
            String bw = br.readLine();
            for (int j = 0; j < m; j++) {
                if (bw.charAt(j) == 'W') {
                    chs[i][j] = true;
                }
            }
        }
        int minResult = 64; // 최솟값 저장
        // 전체 판에서 검사해야 하는 판 분리
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                // 8x8판 검사
                int count = 0; // 바꾼 개수
                for (int r = i; r < i + 8; r++) {
                    for (int k = j; k < j + 8; k++) {
                        // 첫 번째 칸이 white인 기준 계산
                        boolean expected = ((r + k) % 2 == 0); // 합이 짝수면 white
                        if (chs[r][k] != expected) {
                            count++;
                        }
                    }
                }
                int realMin = Math.min(count, 64 - count);
                // 최솟값 업데이트
                minResult = Math.min(minResult, realMin);
            }
        }
        System.out.print(minResult);
    }
}