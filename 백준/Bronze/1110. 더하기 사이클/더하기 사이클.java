import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());

        int original=n;

        int next=0;
        int count=0;
        while(true) {
            next = (n % 10) * 10 + (n / 10 + n % 10) % 10;
            count++;
            if(original==next){
                break;
            }
            // 다음 루프
            n=next;
        }
        System.out.print(count);
    }
}