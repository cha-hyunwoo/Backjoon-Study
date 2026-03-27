import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        for(int i=n;i<=m;i++){
            isPrime(i);
        }
        System.out.print(sb);
    }
    static void isPrime(int num){
        if(num<2) return;
        for(int i=2;i*i<=num;i++){
            if(num%i==0)return;
        }
        sb.append(num).append("\n");
    }
}
