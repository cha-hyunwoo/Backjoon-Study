import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x=Integer.parseInt(br.readLine());

        int n=1; // 1번 라인부터 시작

        while(x>n){ // x가 현재 라인보다 크다면
            x-=n; // 현재 라인만큼 x차감
            n++; // 라인 증가
        }
        // 루프 나오면 n은 x가 속한 라인 번호
        // x는 그 라인에서 몇번째인지

        if(n%2==0){
            // 짝수 라인
            System.out.print(x+"/"+(n+1-x));
        }else{
            // 홀수 라인
            System.out.print((n+1-x)+"/"+x);
        }
    }
}