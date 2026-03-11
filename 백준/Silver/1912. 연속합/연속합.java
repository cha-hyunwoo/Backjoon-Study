import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int []a=new int[n];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(st.nextToken());
        }

        int []dp=new int[n];
        int max=0;

        dp[0]=a[0];
        for(int i=1;i<n;i++){
            dp[i]=Math.max(a[i],dp[i-1]+a[i]);
        }
        Arrays.sort(dp);
        System.out.print(dp[n-1]);
    }
}
