import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited; // 방문 체크용
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수
        int s = Integer.parseInt(st.nextToken()); // 탐색 시작 정점

        graph = new ArrayList[n + 1]; // 1번부터 쓸거니 n+1
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>(); // 배열을 빈 리스트로 각각 초기화
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // u와 v 연결되있음
            graph[u].add(v);
            graph[v].add(u);
        }
        // 작은 것부터 방문해야하니 오름차순 정렬
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }
        visited = new boolean[n + 1];
        dfs(s);

        System.out.println();

        visited = new boolean[n + 1];
        bfs(s);

    }

    // 깊이 우선 탐색
    public static void dfs(int node) {
        visited[node] = true; // 방문 함
        System.out.print(node + " "); // 방문 출력

        for (int next : graph[node]) {
            // 안가본 곳은 바로 감
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    // 너비 우선 탐색
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(start); // 시작점 큐에 넣기
        visited[start] = true; // 큐에 또 넣을 수 있으니 체크

        while (!q.isEmpty()) {
            int node = q.poll(); // 하나 꺼내기
            System.out.print(node + " ");

            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true; // 방문 체크
                    q.offer(next);
                }
            }
        }
    }
}