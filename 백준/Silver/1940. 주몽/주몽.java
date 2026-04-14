import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int []arr=new int[n];
        boolean[] exists = new boolean[100001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i]=num;
            exists[num] = true;
        }

        int count=0;
        for(int i=0;i<n;i++){
            int target=m-arr[i];
            if(target>=0&&target<=100000&&exists[target]&&target!=arr[i]){
                count++;
                exists[target]=false;
                exists[arr[i]]=false;
            }
        }
        System.out.print(count);
    }
}