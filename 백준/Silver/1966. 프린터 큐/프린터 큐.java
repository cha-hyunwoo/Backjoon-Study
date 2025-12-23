import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken()); // 전체 큐 개수






        for (int i = 0; i < t; i++) {
            st = new StringTokenizer((br.readLine()));
            int n = Integer.parseInt(st.nextToken()); // 문서 개수
            int m = Integer.parseInt(st.nextToken()); // 찾을거 인덱스

            int count = 1;
            Deque<int[]> dq = new ArrayDeque<>();
            // 우선순위 큐
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer((br.readLine()));

            for (int j = 0; j < n; j++) {
                int priority = Integer.parseInt(st.nextToken());
                dq.offer(new int[]{j, priority}); // 문서 정보
                pq.offer(priority); // 중요도 정보
            }

            while (!dq.isEmpty()) {
                if (dq.peek()[1] == pq.peek()) {
                    if(dq.peek()[0]==m){
                        sb.append(count+"\n");
                        break;
                    }
                    pq.poll();
                    dq.poll();
                    count++;
                }else{
                    dq.offer(dq.poll());
                }
            }
        }
        System.out.print(sb);
    }
}