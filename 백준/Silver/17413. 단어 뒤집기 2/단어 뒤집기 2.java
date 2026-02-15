import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        boolean inTag = false; // 태그 내부인지
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '<') {
                // 태그 시작하면 스택에 있는거부터 뱉기
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                inTag = true;
                sb.append(c);
            } else if (c == '>') {
                inTag = false;
                sb.append(c);
            } else {
                if (inTag) {
                    // 태그 내부라면 바로 추가
                    sb.append(c);
                } else {
                    // 태그 밖이면
                    if (c == ' ') {
                        // 공백 만나면?
                        while (!stack.isEmpty()) {
                            sb.append(stack.pop());
                        }
                        sb.append(c);
                    } else {
                        stack.push(c);
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.print(sb);
    }
}