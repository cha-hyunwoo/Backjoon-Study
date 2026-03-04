import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[]graph;
    static int[]parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());

        graph=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<n-1;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            // 그래프 연결
            graph[u].add(v);
            graph[v].add(u);
        }
        parent=new int[n+1];
        dfs(1);
        
        StringBuilder sb=new StringBuilder();
        for(int i=2;i<=n;i++){
            sb.append(parent[i]).append('\n');
        }
        System.out.print(sb);
    }
    static public void dfs(int current){
        for(int next:graph[current]){
            if(parent[next]==0){
                parent[next]=current;
                dfs(next);
            }
        }
    }
}