import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int []small=new int[9];
        int totalSum=0;
        for(int i=0;i<9;i++){
            small[i]=Integer.parseInt(br.readLine());
            totalSum+=small[i];
        }
        Arrays.sort(small);

        int spy1=-1;
        int spy2=-1;
        // 총합에서 2명씩 빼보기
        for(int i=0;i<8;i++){
            for(int j=i+1;j<9;j++){
                if(totalSum-(small[i]+small[j])==100){
                    spy1=i;
                    spy2=j;
                    break;
                }
            }
        }
        for(int i=0;i<9;i++){
            if(i==spy1 || i==spy2){
                continue;
            }
            System.out.println(small[i]);
        }

    }
}