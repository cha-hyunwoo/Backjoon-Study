import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][]w;
    static boolean[]visited;
    static int min=Integer.MAX_VALUE;
    static int start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(br.readLine());
        w=new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                w[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        start=0;
        visited = new boolean[n];
        visited[0]=true;
        dfs(0,1,0);

        System.out.println(min);
    }
    static void dfs(int now,int count,int cost){
        // 이미 최소비용을 넘었으면 리턴
        if(cost>=min){
            return;
        }
        // 모든 도시를 다 방문했을 때
        if(count==n){
            // 마지막 도시에서 처음 출발지로 돌아가는 길 있는지 확인
            if(w[now][start]!=0){
                min=Math.min(min,cost+w[now][start]);
            }
            return;
        }

        // 다음 도시 탐색
        for(int i=0;i<n;i++){
            if(!visited[i]&&w[now][i]!=0){
                visited[i]=true;
                dfs(i,count+1,cost+w[now][i]);
                visited[i]=false;
            }
        }
    }
}
