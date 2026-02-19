import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        int n=Integer.parseInt(br.readLine()); // 도시의 개수

        StringTokenizer st=new StringTokenizer(br.readLine());
        long []length=new long[n-1]; // 도로 사이의 길이
        for(int i=0;i<n-1;i++){
            length[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        long []cost=new long[n-1];
        for(int i=0;i<n-1;i++){
            cost[i]=Integer.parseInt(st.nextToken());
        }
        long min=cost[0]*length[0];
        long lowCost=cost[0];
        for(int i=1;i<n-1;i++){
            if(lowCost>cost[i]){
                lowCost=cost[i];
            }
            min+=lowCost*length[i];
        }
        System.out.print(min);
    }
}