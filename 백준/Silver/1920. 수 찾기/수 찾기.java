import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 입력받을 정수 개수

        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            a[i] = x;
        }

        Arrays.sort(a);

        int m = Integer.parseInt(br.readLine()); // 찾을 숫자 개수

        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int y = Integer.parseInt(st.nextToken());
            b[i] = y;
        }

        for (int i = 0; i < m; i++) {
            // b배열의 값이 a를 초과할 경우
            if (b[i] > a[n - 1] || b[i] < a[0]) {
                sb.append(0).append("\n");
                continue;
            }
            // 이분 탐색
            if (Arrays.binarySearch(a, b[i]) >= 0) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.print(sb);
    }
}
