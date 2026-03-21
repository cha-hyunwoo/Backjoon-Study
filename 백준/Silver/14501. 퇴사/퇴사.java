import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int max=0;
    static int [] d;
    static int [] c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine()); // 일
        d=new int[n+1]; // 상담에 걸리는 일수
        c=new int[n+1]; // 상담했을 때 받는 돈
        for(int i=1;i<=n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            d[i]=Integer.parseInt(st.nextToken());
            c[i]=Integer.parseInt(st.nextToken());
        }
        dfs(1,0);

        System.out.print(max);
    }

    static void dfs(int day,int sum){
        if(day==n+1){
            max=Math.max(max,sum);
            return;
        }
        if(day>n+1){
            return;
        }
        // 오늘 상담을 하는 경우
        dfs(day+d[day],sum+c[day]);

        // 오늘 상담을 안하는 경우
        dfs(day+1,sum);
    }
}
