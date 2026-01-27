import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());

        int []dp=new int[1001];

        dp[1]=1; // n=1일 때 1가지
        if(n>=2)dp[2]=2; // n=2일 때 2가지

        for(int i=3;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])%10007;
        }
        System.out.print(dp[n]);
    }
}