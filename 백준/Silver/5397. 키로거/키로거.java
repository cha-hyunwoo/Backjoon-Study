import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        while(tc-->0) {
            String s = br.readLine(); // 강산이가 입력한 문자열

            // 커서를 기준으로 왼쪽 글자는 left, 오른쪽 글자들은 right에 저장
            Stack<Character>left=new Stack<>();
            Stack<Character>right=new Stack<>();

            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);

                switch(c){
                    case '<': // 커서를 왼쪽으로, 왼쪽 글자를 오른쪽으로 옮김
                        if(!left.isEmpty()){
                            right.push(left.pop());
                        }
                        break;
                    case '>': // 커서를 오른쪽으로, 오른쪽 글자를 왼쪽으로 옮김
                        if(!right.isEmpty()){
                            left.push(right.pop());
                        }
                        break;
                    case '-': // 왼쪽 글자 하나 삭제
                        if(!left.isEmpty()){
                            left.pop();
                        }
                        break;
                    default: // 일반 글자, 왼쪽 스택에 추가
                        left.push(c);
                        break;
                }
            }
            // 왼쪽 스택은 아래부터, 오른쪽 스택은 위부터
            StringBuilder sb=new StringBuilder();

            for(Character ch:left){
                sb.append(ch);
            }

            while(!right.isEmpty()){
                sb.append(right.pop());
            }
            System.out.println(sb);
        }
    }
}