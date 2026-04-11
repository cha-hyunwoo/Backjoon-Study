import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st=new StringTokenizer(br.readLine());

        int []arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int x=Integer.parseInt(br.readLine());
        int L=0;
        int R=n-1;
        int count=0;

        while(L<R){
            int sum=arr[L]+arr[R];
            if(sum==x){
                count++;
                L++;
                R--;
            }else if(sum<x){
                L++;
            }else{
                R--;
            }
        }
        System.out.print(count);
    }
}