import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        int [][]map=new int[n][m];


        for(int i=0;i<n;i++){
            String nums=br.readLine();
            for(int j=0;j<m;j++){
                map[i][j]=nums.charAt(j);
            }
        }
        // 더 작은 변으로 최대 변 길이 설정
        int max=Math.min(n,m);
        for(int k=max-1;k>=0;k--){
            for(int i=0;i<n-k;i++){
                for(int j=0;j<m-k;j++){
                    // 네 꼭지점이 같은지 확인
                    if(map[i][j]==map[i+k][j]&&
                    map[i][j]==map[i][j+k]&&
                    map[i][j]==map[i+k][j+k]){
                            
                        System.out.print((k+1)*(k+1));
                        return;
                    }
                }
            }
        }
    }
}