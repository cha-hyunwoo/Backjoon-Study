import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());

        int count=0;
        while(x>0){
            if(x%2==1){ // 아직 2로 나눴을때 나머지가 있다면(끝나지 않은 경우)
                count++;
            }
            x/=2;
        }
        System.out.print(count);
    }
}