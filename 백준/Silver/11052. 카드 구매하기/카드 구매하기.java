import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine()); // 구매하려는 카드의 개수

        StringTokenizer st=new StringTokenizer(br.readLine());
        int []cards=new int[n+1];
        for(int i=1;i<=n;i++){
            cards[i]=Integer.parseInt(st.nextToken());
        }
        int []dp=new int[n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i]=Math.max(dp[i],dp[i-j]+cards[j]);
            }
        }
        System.out.println(dp[n]);
    }
}
