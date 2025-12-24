import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 전체 큐 개수

        int m = Integer.parseInt(st.nextToken()); // 뽑을거 개수

        LinkedList<Integer> dq = new LinkedList<>();
        st = new StringTokenizer(br.readLine());

        int count = 0;
        for (int i = 1; i <= n; i++) {
            dq.offerLast(i);
        }
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());

            // 타겟이 현재 큐의 몇 번째인지
            int index = dq.indexOf(target);

            // 현재 큐의 절반 지점
            int halfIndex = dq.size() / 2;

            while (dq.peekFirst() != target) {
                if (index <= halfIndex) {
                    dq.offerLast(dq.pollFirst());
                    count++;
                } else {
                    dq.offerFirst(dq.pollLast());
                    count++;
                }
            }
            dq.pollFirst();
        }
        System.out.print(count);
    }
}