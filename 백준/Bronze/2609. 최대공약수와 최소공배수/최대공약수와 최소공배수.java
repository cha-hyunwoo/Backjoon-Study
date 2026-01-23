import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        solution(n,m);
    }

    static public void solution(int n,int m){
        int max=0; // 최대 공약수 저장
        int min=0; // 최소 공배수
        for(int i=1;i<=Math.max(n,m);i++){
            if(n%i==0&&m%i==0){
                max=i;
            }
        }
        System.out.println(max);

        min=(n*m)/max; // 최소 공배수 구하기

        System.out.print(min);
    }
}