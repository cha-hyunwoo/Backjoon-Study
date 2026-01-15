import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long s = Long.parseLong(br.readLine()); // 서로 다른 n개의 자연수의 합

        long count=1;
        long sum=0; // 합 저장할 변수
        while(true){
            sum+=count;
            if(sum>s){
                break;
            }
            count++;
        }
        System.out.print(count-1);
    }
}