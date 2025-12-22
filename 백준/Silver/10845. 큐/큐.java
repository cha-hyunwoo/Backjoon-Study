import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());


        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    q.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "front":
                    if (!q.isEmpty()) {
                        System.out.println(q.peekFirst());
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case "back":
                    if (!q.isEmpty()) {
                        System.out.println(q.peekLast());
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case "empty":
                    if (!q.isEmpty()) {
                        System.out.println(0);
                    } else {
                        System.out.println(1);
                    }
                    break;
                case "pop":
                    if (!q.isEmpty()) {
                        System.out.println(q.pollFirst());
                    } else {
                        System.out.println(-1);
                    }
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
            }
        }
    }
}


