import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int map[][];
    static int count = 0;
    static ArrayList<int[]> spaces = new ArrayList<>(); // 0인 곳들
    static ArrayList<int[]> viruses = new ArrayList<>(); // 2인 곳들
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int maxSafety=0; // 최종 정답을 담을 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 직사각형 세로 길이
        m = Integer.parseInt(st.nextToken()); // 직사각형 가로 길이

        // 맵 좌표 배열 생성
        map = new int[n][m];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int k = Integer.parseInt(st.nextToken());
                map[i][j] = k;
                if (k == 0) {
                    spaces.add(new int[]{i, j});
                }
                if (k == 2) {
                    viruses.add(new int[]{i, j});
                }
            }
        }

        buildWall(0,0);

        System.out.print(maxSafety);


    }

    public static void bfs() {
        Queue<int[]> q=new LinkedList<>();
        int[][] copyMap = new int[n][m];

        // 지도 복사, 바이러스 큐에 넣기
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                copyMap[i][j]=map[i][j];
            }
        }
        for(int[] v:viruses){
            q.offer(v);
        }

        // 바이러스 확산
        while(!q.isEmpty()){
            int[] curr=q.poll();
            for(int i=0;i<4;i++){
                int nr=curr[0]+dr[i];
                int nc=curr[1]+dc[i];

                if(nr>=0&&nr<n&&nc>=0&&nc<m){
                    if(copyMap[nr][nc]==0){ // 빈칸이면 전염
                        copyMap[nr][nc]=2;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
        }

        // 안전 영역(0) 개수 세기
        int safeCount=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(copyMap[i][j]==0)safeCount++;
            }
        }
        maxSafety=Math.max(maxSafety,safeCount);

    }

    public static void buildWall(int idx, int cnt) {
        if (cnt == 3) {
            // 벽 3개가 다 세워지면 바이러스 퍼뜨려 보기
            bfs();
            return;
        }

        // spaces리스트 돌면서 벽 세우기
        for (int i = idx; i < spaces.size(); i++) {
            int[] pos = spaces.get(i);
            map[pos[0]][pos[1]] = 1; // 벽 설치
            buildWall(i + 1, cnt + 1); // 다음 벽 설치하러 가기
            map[pos[0]][pos[1]] = 0; // 벽 다시 허물기(백트레킹)
        }
    }
}
