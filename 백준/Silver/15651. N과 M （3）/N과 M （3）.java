import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n,m;
    public static int[]arr;
    public static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        arr=new int[m];
        dfs(0);
        System.out.print(sb);
    }
    public static void dfs(int depth){
        // 목표 개수만큼 다 뽑으면
        if(depth==m) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        for(int i=1;i<=n;i++){
            arr[depth]=i; // 현재 깊이에 숫자 저장

            dfs(depth+1);
        }
    }
}