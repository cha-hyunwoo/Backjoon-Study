import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine()); // 단어의 수
        
        int count=0;

        for(int i=0;i<n;i++){
            Stack<Character> stack=new Stack<>();
            String s=br.readLine();

            for(int j=0;j<s.length();j++){
                char c=s.charAt(j);

                // 스택이 안 비어있고, 맨 위 글자랑 지금 글자가 같으면?
                if(!stack.isEmpty()&&stack.peek()==c){
                    stack.pop();
                }else{
                    // 스택이 비었거나, 짝이 안 맞으면 넣기
                    stack.push(c);
                }
            }
            // 다 돌았는데 스택이 비었으면 좋은 단어
            if(stack.isEmpty()){
                count++;
            }
        }
        System.out.print(count);
    }
}