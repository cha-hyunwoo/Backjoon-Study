import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s=br.readLine().split("-");

        int sum=0;
        for(int i=0;i<s.length;i++){
            int temp=0;
            String[] addition=s[i].split("\\+");
            for(String a:addition){
                temp+=Integer.parseInt(a);
            }
            
            // 첫 덩어리면 더하고 뒤는 뺀다
            if(i==0){
                sum+=temp;
            }else{
                sum-=temp;
            }
        }
        System.out.print(sum);
    }
}
