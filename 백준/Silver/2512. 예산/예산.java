import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine()); // 지방의 수
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int start=0;
        int end=0;
        
        int []requests=new int[n];
        for(int i=0;i<n;i++){
            requests[i]=Integer.parseInt(st.nextToken());
            // 요청 금액 중 최댓값을 상한값으로 설정
            if(requests[i]>end){
                end=requests[i];
            }
        }
        long m=Long.parseLong(br.readLine()); // 총 예산
        
        int result=0;
        
        while(start<=end){
            int mid=(start+end)/2; // 임시 상한액
            long currentSum=0;
            
            for(int i=0;i<n;i++){
                // 요청액이 상환액보다 크면 상환액만큼 주고, 작으면 요청액 다 줌
                if(requests[i]>mid){
                    currentSum+=mid;
                }else{
                    currentSum+=requests[i];
                }
            }
            
            if(currentSum<=m){
                // 예산 안쪽이면 상한액 높이기
                result=mid; // 현재 상환액 기록
                start=mid+1;
            }else{
                // 에산 초과면 상환액 낮추기
                end=mid-1;
            }
        }
        System.out.print(result);
    }
}