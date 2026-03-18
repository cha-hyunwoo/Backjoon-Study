import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());

        int []height=new int[1001];
        int maxH=0; // 가장 높은 기둥의 높이
        int maxIdx=0; // 가장 높은 기둥의 위치
        int lastIdx=0; // 가장 오른쪽에 있는 기둥 위치

        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int l=Integer.parseInt(st.nextToken());
            int h=Integer.parseInt(st.nextToken());
            if(maxH<h){
                maxH=h;
                maxIdx=l;
            }
            height[l]=h;

            lastIdx=Math.max(lastIdx,l); // 가장 오른쪽 기둥 위치 갱신
        }

        int currentH=0;
        int sum=0;
        for(int i=0;i<=maxIdx;i++){
            currentH=Math.max(currentH,height[i]);
            sum+=currentH;
        }

        currentH=0;
        for(int i=lastIdx;i>maxIdx;i--){
            currentH=Math.max(currentH,height[i]);
            sum+=currentH;
        }
        System.out.print(sum);
    }
}
