import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[]adj;
    static int[]dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 전체 사람 수

        StringTokenizer st=new StringTokenizer(br.readLine());

        // 촌수를 계산해야 하는 두 사람
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());

        int m=Integer.parseInt(br.readLine());
        adj=new ArrayList[n+1];
        dist=new int[n+1];
        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
            dist[i]=-1; // -1 초기화(방문 안함)
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            // 양방향 연결
            adj[x].add(y);
            adj[y].add(x);
        }

        System.out.println(bfs(a,b));
    }
    static int bfs(int a,int b){
        Queue<Integer>q=new LinkedList<>();
        q.add(a);
        // 시작점 이동 0
        dist[a]=0;

        while(!q.isEmpty()){
            int cur=q.poll();

            if(cur==b){
                // 찾으면 현재 촌수 반환
                return dist[cur];
            }
            for(int next:adj[cur]){
                // 처음 방문하면
                if(dist[next]==-1){
                    dist[next]=dist[cur]+1;
                    q.add(next);
                }
            }
        }
        return -1; // 다 돌아도 못 찾으면 남
    }
}
