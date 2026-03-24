import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine()); //배열의크기

        StringTokenizer st=new StringTokenizer(br.readLine());
        int []a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(st.nextToken());
        }
        int []b=a.clone();
        Arrays.sort(b);
        
        // 중복 체크를 위한 방문 체크
        boolean[] visited= new boolean[n];

        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(a[i]==b[j]&&!visited[j]){
                    sb.append(j).append(" ");
                    visited[j]=true;
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}
