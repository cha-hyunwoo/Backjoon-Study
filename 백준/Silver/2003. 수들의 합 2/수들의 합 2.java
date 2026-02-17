import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(st.nextToken());
        }
        int count=0;
        int sum=0;
        int start=0;
        int end=0;

        while(true){
            if(sum>=m){
                // 합이 크거나 같으면 왼쪽을 줄임
                sum-=a[start++];
            }else if(end==n){
                // 더할 게 없는데 합도 작으면 끝
                break;
            }else{
                // 합이 작으면 오른쪽을 늘림
                sum+=a[end++];
            }
            if(sum==m){
                count++;
            }
        }
        System.out.print(count);
    }
}