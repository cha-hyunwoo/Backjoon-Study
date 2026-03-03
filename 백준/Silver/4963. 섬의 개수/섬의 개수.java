import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int w,h;
    static int[][]map;
    static boolean[][]visited;
    static int[] dx={-1, 1, 0, 0, -1, -1, 1, 1};
    static int[]dy={0, 0, -1, 1, -1, 1, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st=new StringTokenizer(br.readLine());
            w=Integer.parseInt(st.nextToken());
            h=Integer.parseInt(st.nextToken());
            if(w==0 && h==0)break; // 종료 조건

            map=new int[h][w];
            visited=new boolean[h][w];

            for(int i=0;i<h;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<w;j++){
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            int count=0;
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    // 방문하지 않은 새로운 섬 발견하면 체크
                    if(map[i][j]==1&&!visited[i][j]){
                        // 연결된 섬 전부 방문 체크
                        dfs(i,j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }
    public static void dfs(int x,int y){
        visited[x][y]=true;

        for(int i=0;i<8;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx>=0&&ny>=0&&nx<h&&ny<w){
                if(map[nx][ny]==1&&!visited[nx][ny]){
                    dfs(nx,ny);
                }
            }
        }
    }
}