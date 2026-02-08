import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int lope[] = new int[n];
        for (int i = 0; i < n; i++) {
            lope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lope);
        int max=0;
        for(int i=0;i<n;i++){
            if(max<lope[i]*(n-i)){
                max=lope[i]*(n-i);
            }
        }
        System.out.print(max);
    }
}