import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (!q.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                q.add(q.poll());
            }
            sb.append(q.poll());

            if (!q.isEmpty()) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.print(sb);
    }
}