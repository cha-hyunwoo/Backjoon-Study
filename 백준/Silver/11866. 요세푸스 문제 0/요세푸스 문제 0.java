import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int count = 1;

        Deque<Integer> dq = new ArrayDeque<>();
        Deque<Integer> dqq = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            dq.offerLast(i);
        }

        while (!dq.isEmpty()) {
            if (count % k == 0) {
                // 3의 배수마다 빼서 다른 덱에 저장
                dqq.offerLast(dq.pollFirst());
            } else {
                // 3의 배수가 아닐땐 빼서 뒤에 다시 붙이기
                dq.offerLast(dq.pollFirst());
            }
            count++;
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                System.out.print("<");
            }
            System.out.print(dqq.pollFirst());
            if (i != n - 1) {
                System.out.print(", ");
            }
            if (i == n - 1) {
                System.out.print(">");
            }
        }
    }
}