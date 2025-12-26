import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited; // 방문 체크용
    static int[][] map; // 배추밭
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int m;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 배추밭의 가로길이
            n = Integer.parseInt(st.nextToken()); // 배추밭의 세로길이
            int k = Integer.parseInt(st.nextToken()); // 배추가 심어진 위치의 개수
            // 배열 먼저 생성
            map = new int[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1; // 배추 위치에 1삽입
            }

            int count = 0; // 지렁이 수

            for (int i = 0; i < n; i++) { // 세로
                for (int j = 0; j < m; j++) { // 가로
                    if (map[i][j] == 1 && !visited[i][j]) {
                        count++;
                        dfs(j, i);
                    }
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }

    // 깊이 우선 탐색
    public static void dfs(int x, int y) {
        visited[y][x] = true; // 방문 함
        // 상하좌우 4방향 확인
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i]; // 새로운 x좌표
            int ny = y + dy[i]; // 새로운 y좌표

            // 지도 범위 안인지 체크
            if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                // 배추가 있고 && 아직 안 가봤으면
                if (map[ny][nx] == 1 && !visited[ny][nx]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}