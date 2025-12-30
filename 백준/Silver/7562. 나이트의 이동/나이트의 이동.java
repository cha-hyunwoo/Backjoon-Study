import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int count = 0;
    static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};
    static int maxSafety = 0; // 최종 정답을 담을 변수
    static int l;
    static int cx;
    static int cy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < tc; i++) {
            l = Integer.parseInt(br.readLine()); // 체스판 크기
            int map[][] = new int[l][l]; // 체스판 생성

            StringTokenizer st = new StringTokenizer(br.readLine());
            cx = Integer.parseInt(st.nextToken());
            cy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int nx = Integer.parseInt(st.nextToken());
            int ny = Integer.parseInt(st.nextToken());

            dfs(nx, ny);
        }
    }

    static public void dfs(int nx, int ny) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{cx, cy});

        int[][] visited = new int[l][l];
        // 모든 칸 -1 초기화
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                visited[i][j] = -1;
            }
        }
        // 시작 지점 방문횟수 0 설정
        visited[cx][cy] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            // 도착했으면 끝내기
            if (curr[0] == nx && curr[1] == ny) {
                System.out.println(visited[curr[0]][curr[1]]);
                return;
            }
            // 갈 수 있는 칸 다 찍으면서 최솟값 알아내기
            for (int i = 0; i < 8; i++) {
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];

                if (nr >= 0 && nc >= 0 && nr < l && nc < l && visited[nr][nc] == -1) {
                    visited[nr][nc] = visited[curr[0]][curr[1]] + 1; // 방문 좌표에 이동 횟수 저장
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }


}
