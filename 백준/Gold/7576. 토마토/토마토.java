import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map; // 미로 맵
    static int m;
    static int n;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 미로의 가로길이
        m = Integer.parseInt(st.nextToken()); // 미로의 세로길이

        // 배열 먼저 생성
        map = new int[m][n];

        // 익은 토마토 저장할 배열
        Queue<int[]> tom = new ArrayDeque<>();

        // map에 토마토 구별해서 넣기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int k = Integer.parseInt(st.nextToken());
                if (k == 1) {
                    tom.offer(new int[]{i, j}); // 익은 토마토 위치를 큐에 저장
                }
                map[i][j] = k; // 맵에는 전체 저장
            }
        }

        while (!tom.isEmpty()) {
            int[] curr = tom.poll(); // 하나 꺼내기
            int cx = curr[1]; // 현재 x좌표
            int cy = curr[0]; // 현재 y좌표
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i]; // 퍼진 x좌표
                int ny = cy + dy[i]; // 퍼진 y좌표

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (map[ny][nx] == 0) {
                        map[ny][nx] = map[cy][cx] + 1; // 다음날 익었으니 하루 추가
                        tom.offer(new int[]{ny, nx});
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    System.out.print(-1);
                    return;
                }
                if (max < map[i][j]) {
                    max = map[i][j];
                }
            }
        }
        System.out.print(max - 1); // 1에서 시작했으니 하루 뺌
    }
}
