import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] dp = new int[31][31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()); // 테스트 케이스 개수


        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 강 동쪽
            int m = Integer.parseInt(st.nextToken()); // 강 서쪽

            sb.append(bc(m,n)).append("\n");
        }
        System.out.print(sb);
    }

    static public int bc(int n, int k) {
        if (dp[n][k] > 0) {
            return dp[n][k];
        }
        if (k == 0 || n == k) {
            return dp[n][k] = 1;
        }
        return dp[n][k] = bc(n - 1, k - 1) + bc(n - 1, k);
    }
}