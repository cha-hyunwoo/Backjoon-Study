import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[]adj;
    static int[]dist;
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
        
        for(int i=0;i<n;i++){
            dp[i]=1; // 자신 길이 1
            
            for(int j=0;j<i;j++){
                // 앞에 있는게 나보다 크면 길이 늘리기
                if(a[j]>a[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(max,dp[i]);
        }
        System.out.print(max);
    }
}
