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


        Deque<Integer> dq = new ArrayDeque<>();


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push_back":
                    dq.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "push_front":
                    dq.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "front":
                    if (!dq.isEmpty()) {
                        System.out.println(dq.peekFirst());
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case "back":
                    if (!dq.isEmpty()) {
                        System.out.println(dq.peekLast());
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case "size":
                    System.out.println(dq.size());
                    break;
                case "empty":
                    if (!dq.isEmpty()) {
                        System.out.println(0);
                    } else {
                        System.out.println(1);
                    }
                    break;
                case "pop_front":
                    if (!dq.isEmpty()) {
                        System.out.println(dq.pollFirst());
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case "pop_back":
                    if (!dq.isEmpty()) {
                        System.out.println(dq.pollLast());
                    } else {
                        System.out.println(-1);
                    }
                    break;
            }
        }
    }
}