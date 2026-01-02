import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine()); // 인원 수

        int [] array=new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int p=Integer.parseInt(st.nextToken()); // 인출하는데 걸리는 시간
            array[i]=p;
        }

        Arrays.sort(array);

        int sum=0;
        
        for(int i=0;i<n;i++){
            sum+=array[i]*(n-i);
        }
        
        System.out.print(sum);
    }
}
