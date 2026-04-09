import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long dp[]=new long[91];

        dp[1]=1;
        // 아래식 인덱스 오류 방지
        if(n>=2){
            dp[2]=1;
        }
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
            // dp[i-1] 뒤에 0붙이고 dp[i-2]뒤에 01붙이기
        }
        System.out.print(dp[n]);
    }
}