import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] board;
    static int mOne = 0; // -1로 채워진 종이
    static int zero = 0; // 0으로 채워진 종이
    static int one = 0; // 1로 채워진 종이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 한 변의 길이

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, n);

        System.out.println(mOne);
        System.out.println(zero);
        System.out.print(one);
    }

    public static void partition(int row, int col, int size) {
        if (numCheck(row, col, size)) {
            if (board[row][col] == 0) {
                zero++;
            } else if (board[row][col] == -1) {
                mOne++;
            } else {
                one++;
            }
            return;
        }

        // 같은 수가 아니라면 3등분
        int newSize = size / 3;
        partition(row, col, newSize); // 좌측 상단
        partition(row, col + newSize, newSize); // 중간 상단
        partition(row, col + (newSize * 2), newSize); // 우측 상단

        partition(row + newSize, col, newSize); // 좌측 중단
        partition(row + newSize, col + newSize, newSize); // 중간 중단
        partition(row + newSize, col + (newSize * 2), newSize); // 우측 중단

        partition(row + (newSize * 2), col, newSize); // 좌측 하단
        partition(row + (newSize * 2), col + newSize, newSize); // 중간 하단
        partition(row + (newSize * 2), col + (newSize * 2), newSize); // 우측 하단
    }

    public static boolean numCheck(int row, int col, int size) {
        int num = board[row][col]; // 첫 번째 칸 색깔 기준

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] != num) {
                    return false;
                }
            }
        }
        return true;
    }
}