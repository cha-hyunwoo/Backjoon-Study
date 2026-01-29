import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] board;
    static int white = 0;
    static int blue = 0;

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

        partition(0,0,n);

        System.out.println(white);
        System.out.print(blue);
    }

    public static void partition(int row, int col, int size) {
        if (colorCheck(row, col, size)) {
            if (board[row][col] == 0) {
                white++;
            }else{
                blue++;
            }return;
        }

        // 같은 색이 아니라면 4등분
        int newSize=size/2;
        partition(row,col,newSize); // 좌측 상단
        partition(row,col+newSize,newSize); // 우측 상단
        partition(row+newSize,col,newSize); // 좌측 상단
        partition(row+newSize,col+newSize,newSize); // 우측 하단
    }

    public static boolean colorCheck(int row, int col, int size) {
        int color = board[row][col]; // 첫 번째 칸 색깔 기준

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}