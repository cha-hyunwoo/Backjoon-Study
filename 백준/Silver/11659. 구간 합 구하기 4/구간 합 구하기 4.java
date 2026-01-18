import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] dp = new int[31][31];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(st.nextToken());  // 수의 개수
        int m=Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수

        int []arrsum=new int[n+1]; // 인덱스 번호까지의 합을 저장하는 배열

        st=new StringTokenizer(br.readLine());

        for(int z=1;z<n+1;z++){
            arrsum[z]=arrsum[z-1]+Integer.parseInt(st.nextToken());
        }

        for(int z=1;z<m+1;z++){
            st=new StringTokenizer(br.readLine());
            int i=Integer.parseInt(st.nextToken());
            int j=Integer.parseInt(st.nextToken());
            // j인덱스까지의 합에서 i-1인덱스까지의 합을 뺌
            sb.append(arrsum[j]-arrsum[i-1]).append("\n");
        }
        System.out.print(sb);
    }
}