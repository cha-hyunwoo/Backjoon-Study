import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] dp = new int[31][31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[][] xy = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                xy[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(xy, (o1, o2) -> {
            if (o1[1] == o2[1]) { // y좌표가 같다면
                return o1[0] - o2[0]; // x좌표 비교
            } else {
                return o1[1] - o2[1]; // y좌표 비교
            }
        });

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                sb.append(xy[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}