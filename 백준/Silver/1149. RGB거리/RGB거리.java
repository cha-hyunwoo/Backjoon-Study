import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 집의 수

        int[][] cost = new int[n][3];

        // 0번 빨강로 끝났을때, 1번 초록으로 끝났을때, 2번 파랑로 끝났을때
        int[][] dp=new int[n][3];


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            cost[i][0] = r;
            cost[i][1] = g;
            cost[i][2] = b;
        }

        dp[0][0]=cost[0][0];
        dp[0][1]=cost[0][1];
        dp[0][2]=cost[0][2];
        for(int i=1;i<n;i++){
            // i번째 집을 빨강으로 칠할 때-> 이전 집 초록, 파랑 중 최솟값 + 빨강 비용
            dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+cost[i][0];

            // i번째 집을 초록으로 칠할 때-> 이전 집 빨강, 파랑 중 최솟값 + 초록 비용
            dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+cost[i][1];

            // i번째 집을 파랑으로 칠할 때-> 이전 집 빨강, 초록 중 최솟값 + 파랑 비용
            dp[i][2]=Math.min(dp[i-1][0],dp[i-1][1])+cost[i][2];
        }

        System.out.print(Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2])));
    }
}