import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue pq=new PriorityQueue();
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                pq.add(Integer.parseInt(st.nextToken()));
                if(pq.size()>n){
                    pq.poll();
                }
            }
        }
        System.out.print(pq.poll());
    }
}
