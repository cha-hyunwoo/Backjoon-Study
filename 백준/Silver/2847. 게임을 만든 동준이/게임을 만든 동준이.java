import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine()); // 레벨

        int score=0;

        int []level=new int[n];
        for(int i=0;i<n;i++){
            level[i]=Integer.parseInt(br.readLine());
        }
        for(int i=n-2;i>=0;i--){
            if(level[i]>=level[i+1]){
                int num=level[i]-level[i+1]+1;
                score+=num;
                level[i]-=num;
            }
        }
        System.out.print(score);
    }
}