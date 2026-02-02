import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int []check=new int[n];
        for(int i=0;i<n;i++){
            check[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(check);
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<n;i++){
            if(i==0||check[i]!=check[i-1]){
                sb.append(check[i]).append(" ");
            }
        }
        System.out.print(sb);
    }
}