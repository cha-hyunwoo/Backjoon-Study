import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        long x=Integer.parseInt(st.nextToken());
        long y=Integer.parseInt(st.nextToken());

        long cur=(y*100)/x; // 현재 승률
        if(cur>=99){
            System.out.print(-1);
            return;
        }
        long start=0;
        long end=1000000000; // 최대 10억 판
        long ans=-1;

        while(start<=end){
            long mid=(start+end)/2; // mid판 더 해보기
            long nextZ=((y+mid)*100)/(x+mid);

            if(nextZ>cur){ // 승률이 올랐다면 답으로 저장 후 더 적게 해도되나 확인
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1; // 승률 안올랐으면 더 해야함
            }
        }
        System.out.print(ans);
    }
}
