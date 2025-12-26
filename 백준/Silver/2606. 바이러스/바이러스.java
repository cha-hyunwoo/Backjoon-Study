import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited; // 방문 체크용
    static ArrayList<Integer>[] graph;
    static int count = 0; // 방문 정점 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int n = Integer.parseInt(br.readLine()); // 정점의 개수
        int m = Integer.parseInt(br.readLine()); // 간선의 개수
        int s = 1;// 탐색 시작 정점


        graph = new ArrayList[n + 1]; // 1번부터 쓸거니 n+1
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>(); // 배열을 빈 리스트로 각각 초기화
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
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
        System.out.print(count - 1); // 1번 정점 제외
    }

    // 깊이 우선 탐색
    public static void dfs(int node) {
        visited[node] = true; // 방문 함
        count++;

        for (int next : graph[node]) {
            // 안가본 곳은 바로 감
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}