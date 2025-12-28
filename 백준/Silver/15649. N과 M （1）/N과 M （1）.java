import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int m;
    static int n;
    static boolean visited[];
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        arr = new int[m];

        dfs(0);

    }

    public static void dfs(int depth) {
        // 목표 개수 뽑고 종료
        if (depth == m) {
            // 배열에 담긴 숫자 출력
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }

        // 1부터 숫자 하나씩 시도
        for (int i = 1; i <= n; i++) {
            // 자바는 배열 만들면 boolean이면 false 자동 입력
            if (!visited[i]) {// 아직 안쓴 숫자라면
                visited[i] = true; // 사용 체크
                arr[depth] = i; // 현재 칸 숫자 저장
                dfs(depth + 1); // 다음 칸
                
                // 백트레킹 다음 줄에서 사용해야하니 false로 상태 복구
                visited[i] = false;
            }
        }
    }
}
