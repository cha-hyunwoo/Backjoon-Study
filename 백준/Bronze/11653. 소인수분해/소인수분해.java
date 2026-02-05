import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 1인 경우 출력x
        if(n==1) return;

        StringBuilder sb=new StringBuilder();

        for(int i=2;i*i<=n;i++){
            while(n%i==0){
                sb.append(i).append("\n");
                n/=i;
            }
        }

        // 루프를 다 돌고 나서도 n>1이라면 이것이 마지막 소인수
        if(n>1){
            sb.append(n).append("\n");
        }
        System.out.print(sb);
    }
}