import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());

            // 입력받은거보다 작은 탑은 다 치움
            while (!stack.isEmpty() && stack.peek()[1] <= num) {
                stack.pop();
            }

            // 다 치웠는데 비었으면 탑 수신x
            if (stack.isEmpty()) {
                sb.append("0 ");
            }
            // 남아있으면 수신 탑
            else {
                sb.append(stack.peek()[0] + " ");
            }
            stack.push(new int[]{i, num});
        }
        System.out.print(sb);
    }
}


