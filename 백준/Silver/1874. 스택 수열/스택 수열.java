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

        int start = 1;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            // start가 입력 받은 숫자까지 커짐
            if (value >= start) {
                while (value >= start) {
                    stack.push(start);
                    start++;
                    sb.append("+\n");
                }
            } 
            if (!stack.isEmpty() && stack.peek() == value) {
                // 스택이 비어있지않고 찾는 값과 같으면 팝
                stack.pop();
                sb.append("-\n");
            } else { // 불가능
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);

    }
}

