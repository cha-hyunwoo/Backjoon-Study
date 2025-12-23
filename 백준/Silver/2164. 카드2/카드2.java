import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());


        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=1;i<=n;i++){
            dq.offerLast(i); // 뒤에 넣기
        }
        for(int i=1;i<n;i++){
            dq.pollFirst(); // 앞에꺼 꺼내기
            dq.offerLast(dq.pollFirst()); // 앞에꺼 뒤로 보내기
        }
        System.out.print(dq.peek());
    }
}


