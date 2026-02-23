import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n,m;
    public static int[]arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        arr=new int[m];
        dfs(1,0);
    }
    public static void dfs(int at,int depth){
        // 목표 개수만큼 다 뽑으면
        if(depth==m) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }
        // at부터 시작해서 숫자 하나씩
        for(int i=at;i<=n;i++){
            arr[depth]=i; // 현재 깊이에 숫자 저장

            // 다음 숫자는 지금 고른 i보다 1 큰 숫자부터 고름
            dfs(i+1,depth+1);
        }
    }
}