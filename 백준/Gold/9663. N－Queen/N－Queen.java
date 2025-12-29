import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static boolean visited[];
    static int rows[];
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine());

        rows = new int[n];
        dfs(0);

        System.out.print(ans);
    }

    public static void dfs(int row) {
        
        // 정답 ++
        if (row == n) {
            ans++;
            return;
        }

        for (int i = 0; i < n; i++) {
            rows[row] = i; // 현재 행의 i번째 열에 둬봄
            if (isPossible(row)) { // 이 자리가 괜찮다면
                dfs(row + 1);
            }
            // 안 괜찮으면 다음 i(열)로 넘어가기
        }
    }

    public static boolean isPossible(int row) {
        for (int i = 0; i < row; i++) {
            // 행의 차이/열의 차이=1 or -1이어야함
            if (rows[row] == rows[i] || Math.abs(row - i) == Math.abs(rows[row] - rows[i])) {
                return false;
            }
        }
        return true;
    }
}
