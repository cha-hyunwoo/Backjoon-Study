import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int st = Integer.parseInt(br.readLine()); // 계단 개수

        // 다이나믹 프로그래밍
        int stair[] = new int[st + 1];

        int score[] = new int[st + 1];
        for (int i = 1; i <= st; i++) {
            stair[i] = Integer.parseInt(br.readLine()); // 계단 점수
        }
        if (st >= 1) {
            score[1] = stair[1];
        }
        if (st >= 2) {
            score[2] = stair[1] + stair[2];
        }
        for (int i = 3; i <= st; i++) {
            // 1칸 전에서 온 경우, 2칸 전에서 온 경우
            score[i] = Math.max(score[i - 3] + stair[i - 1], score[i - 2]) + stair[i];
        }
        System.out.print(score[st]);
    }
}
