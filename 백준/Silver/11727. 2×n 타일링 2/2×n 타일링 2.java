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
        dp[2]=3; // n=2일 때 3가지

        for(int i=3;i<=n;i++){
            // 가로 1칸 놓는 경우 + 가로 2칸 놓는 경우 + 정사각형 놓는 경우
            dp[i]=(dp[i-1]+dp[i-2]+dp[i-2])%10007;
        }
        System.out.print(dp[n]);
    }
}