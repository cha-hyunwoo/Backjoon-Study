import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int map[][];
    static int count = 0;
    static int r;
    static int c;
    static int dr[] = {-1, 0, 1, 0}; // 북 동 남 서 순서
    static int dc[] = {0, 1, 0, -1};
    static int d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 직사각형 가로 길이
        m = Integer.parseInt(st.nextToken()); // 직사각형 세로 길이

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()); // 처음 로봇청소기 y좌표
        c = Integer.parseInt(st.nextToken()); // 처음 로봇청소기 x좌표
        d = Integer.parseInt(st.nextToken()); // 로봇이 바라보는 방향 0-북쪽 1-동쪽 2-남쪽 3-서쪽

        // 맵 좌표 배열 생성
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            // 현재 칸 청소
            if (map[r][c] == 0) {
                map[r][c] = 2; // 청소 완료 표시
                count++;
            }

            boolean cleanable = false;

            // 주변 4칸 확인
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4; // 반시계 방향부터 확인

                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    if (map[nr][nc] == 0) { // 청소 x면
                        r = nr;
                        c = nc;
                        cleanable = true;
                        break;
                    }
                }
            }

            if (!cleanable) {
                // 후진: 현재 방향의 반대방향
                int backDir = (d + 2) % 4;
                int brr = r + dr[backDir];
                int bc = c + dc[backDir];

                // 뒤쪽이 벽(1)아니면 후진 가능
                if (brr >= 0 && brr < n && bc >= 0 && bc < m && map[brr][bc] != 1) {
                    r = brr;
                    c = bc;
                } else {
                    // 뒤가 벽이면 작동 멈춤
                    break;
                }
            }
        }
        System.out.print(count);
    }
}
