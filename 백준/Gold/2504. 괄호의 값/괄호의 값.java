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

        String s = br.readLine();

        int tmp = 1; // 게산용 변수
        int result = 0; // 출력용 변수
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 열린 괄호 계산
            if (c == '(') {
                stack.push(c);
                tmp *= 2;
            } else if (c == '[') {
                stack.push(c);
                tmp *= 3;
            } // 닫힌 괄호 계산
            else if (c == ')') {
                // 스택이 비어있지 않고 가장 위에 있는게 열린괄호라면
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.print(0);
                    System.exit(0);
                }
                // 더하는 경우
                if (s.charAt(i - 1) == '(') {
                    result += tmp;
                }
                stack.pop();
                tmp /= 2;
            } else if (c == ']') {
                // 스택이 비어있지 않고 가장 위에 있는게 열린괄호라면
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.print(0);
                    System.exit(0);
                }
                // 더하는 경우
                if (s.charAt(i - 1) == '[') {
                    result += tmp;
                }
                stack.pop();
                tmp /= 3;
            }
        }
        // 스택이 비어있다면 결과 출력
        if (!stack.isEmpty()) {
            System.out.print(0);
        } else {
            System.out.print(result);
        }
    }
}


