import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        // 체크 리스트 배열
        boolean[] isNotSelfNumber=new boolean[10001];
        for(int i=1;i<10001;i++){
            int k=i;
            int sum=i;
            while(k!=0){
                    sum+=(k%10); // 끝자리 더하기
                if(k/10!=0) {
                    k /= 10; // 한 자리 깍기
                }else{
                    break;
                }
            }
            // 셀프 넘버가 아닌 것 true 체크
            if(sum<=10000) {
                isNotSelfNumber[sum] = true;
            }
        }
        for(int i=1;i<10001;i++){
            if(!isNotSelfNumber[i]){
                sb.append(i).append("\n");
            }
        }
        System.out.print(sb);
    }
}
