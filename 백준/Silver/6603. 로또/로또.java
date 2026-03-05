import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int k;
    static int[]s;
    static int[]result=new int[6];
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st=new StringTokenizer(br.readLine());
            k=Integer.parseInt(st.nextToken());
            if(k==0){
                break;
            }
            s=new int[k];
            for(int i=0;i<k;i++){
                s[i]=Integer.parseInt(st.nextToken());
            }
            dfs(0,0);
            sb.append('\n');
        }
        System.out.print(sb);
    }
    static void dfs(int at, int depth){
        if(depth==6){
            for(int val:result)sb.append(val).append(' ');
            sb.append('\n');
            return;
        }

        for(int i=at;i<k;i++){
            result[depth]=s[i];
            dfs(i+1,depth+1);
        }
    }
}