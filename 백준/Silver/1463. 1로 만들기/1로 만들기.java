import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine()); // 정수 x

        // 다이나믹 프로그래밍
        int dp[] = new int[x + 1];

        for (int i = 2; i <= x; i++) {
            // 일단 1을 빼는 경우 먼저 생각
            dp[i] = dp[i - 1] + 1;
            // 2로 나누어 떨어지고 2로 나눈게 횟수가 더 적다면 갱신
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            // 3로 나누어 떨어지고 3로 나눈게 횟수가 더 적다면 갱신
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        System.out.print(dp[x]);
    }
}
