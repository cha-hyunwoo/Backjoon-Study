import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] visited; // 방문 체크용
    static int[][] map; // 미로 맵
    static int m;
    static int n;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 미로의 세로길이
            m = Integer.parseInt(st.nextToken()); // 미로의 가로길이

            // 배열 먼저 생성
            map = new int[n][m];
            visited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                String line = br.readLine();
                for (int j = 0; j < m; j++) {
                    // 숫자로 만들기 위해 0 빼기
                    map[i][j] = line.charAt(j) - '0';
                }
            }
            // 배열은 0부터 시작하니까 0,0
            bfs(0, 0);
            System.out.print(map[n-1][m-1]);
        }


    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y}); // 시작점 큐에 넣기
        visited[y][x] = true; // 큐에 또 넣을 수 있으니 체크

        while (!q.isEmpty()) {
            int[] curr = q.poll(); // 하나 꺼내기
            int cx = curr[0]; // 현재 x좌표
            int cy = curr[1]; // 현재 y좌표
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i]; // 새로운 x좌표
                int ny = cy + dy[i]; // 새로운 y좌표

                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if (map[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx]=true;
                        map[ny][nx] = map[cy][cx] + 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
