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

        int[] tmp = new int[n];

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            // 오큰수 못찾으면 이게 출력
            tmp[i] = -1;
            // 배열에 답 저장
            while (!stack.isEmpty() && stack.peek()[1] < num) {
                tmp[stack.pop()[0]] = num;
            }
            stack.push(new int[]{i, num});
        }
        // 순서대로 출력
        for (int x : tmp) {
            sb.append(x + " ");
        }
        System.out.print(sb);
    }
}


