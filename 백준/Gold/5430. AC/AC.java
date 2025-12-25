import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수


        for (int i = 0; i < t; i++) {

            boolean isReverse = false; // 뒤집혔는지
            boolean isError = false;
            String command = br.readLine();

            int n = Integer.parseInt(br.readLine());

            // 배열에서 데이터만 받기
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

            Deque<Integer> dq = new ArrayDeque<>();
            while (st.hasMoreTokens()) {
                dq.offer(Integer.parseInt(st.nextToken()));
            }

            for (int j = 0; j < command.length(); j++) {
                char ch = command.charAt(j); // 한 글자 가져오기

                if (ch == 'R') {
                    isReverse = !isReverse;
                } else {
                    if (dq.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReverse == false) {
                        dq.pollFirst();
                    } else {
                        dq.pollLast();
                    }
                }
            }
            if (isError) {
                sb.append("error\n");
            } else {
                sb.append("[");


                if (!dq.isEmpty()) {
                    if (isReverse) {
                        // 뒤집힌 상태면 뒤에서 꺼냄
                        sb.append(dq.pollLast());
                        while (!dq.isEmpty()) {
                            sb.append(",").append(dq.pollLast());
                        }
                    } else {
                        // 정상이면 앞에서 꺼냄
                        sb.append(dq.pollFirst());

                        while (!dq.isEmpty()) {
                            sb.append(",").append(dq.pollFirst());
                        }
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb);
    }
}