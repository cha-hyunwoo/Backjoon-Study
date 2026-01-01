import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 동전 종류 수
        int k = Integer.parseInt(st.nextToken()); // 최종 금액

        // 코인 종류 담을 배열
        int[] coin = new int[n];
        // 코인 개수 담을 변수
        int count = 0;
        // 코인 종류 입력받기
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        for (int i = n - 1; i >= 0; i--) {
            if (k >= coin[i]) {
                count += (k / coin[i]); // 사용할 수 있는 최대 개수 더함
                k %= coin[i]; // 나머지는 다음 동전
            }
        }
        System.out.print(count);
    }
}
