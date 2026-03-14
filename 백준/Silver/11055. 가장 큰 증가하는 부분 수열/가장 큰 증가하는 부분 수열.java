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

        int max=0;
        int []sum=new int[n];
        sum[0]=a[0];
        for(int i=0;i<n;i++){
            sum[i]=a[i];
            for(int j=0;j<i;j++){
                // 앞에 있는게 나보다 작으면 총합 늘리기
                if(a[j]<a[i]){
                    sum[i]=Math.max(sum[i],sum[j]+a[i]);
                }
            }
            max=Math.max(max,sum[i]);
        }
        System.out.print(max);
    }
}
