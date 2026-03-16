import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,s;
    static int[] a;
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        s=Integer.parseInt(st.nextToken());

        a=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(st.nextToken());
        }

        dfs(0,0);

        if(s==0){
            System.out.print(count-1); // 공집합일때 제외
        }else{
            System.out.print(count);
        }
        
    }

    static void dfs(int index,int sum){
        if(index==n){
            if(sum==s){
                count++;
            }
            return;
        }

        dfs(index+1,sum+a[index]);
        dfs(index+1,sum);
    }
}
