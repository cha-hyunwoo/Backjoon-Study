import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n,m;
    public static int[]arr;
    public static int[]nums; // 숫자 담을 곳
    public static boolean[] visited; // 중복 방지 체크용
    public static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        nums=new int[n];
        visited=new boolean[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            nums[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

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

        for(int i=0;i<n;i++){

            if(!visited[i]){
                visited[i]=true;
                arr[depth]=nums[i];
                dfs(depth+1);
                visited[i]=false; // 원상복구
            }
        }
    }
}