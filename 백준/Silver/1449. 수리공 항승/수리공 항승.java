import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken()); // 물이 새는 곳의 개수
        int l=Integer.parseInt(st.nextToken()); // 테이프의 길이

        int []tape=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            tape[i]=Integer.parseInt(st.nextToken());
        }
        int count=1;

        Arrays.sort(tape);
        int start=tape[0];

        for(int i=0;i<n-1;i++){
            int end=tape[i+1];
            if(end-start<l){
                continue;
            }else{
                start=tape[i+1];
                count++;
            }
        }
        System.out.print(count);
    }
}