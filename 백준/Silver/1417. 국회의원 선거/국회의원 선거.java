import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int dasom=Integer.parseInt(br.readLine());
        // 후보가 다솜 혼자일 경우
        if(n==1){
            System.out.print(0);
            return;
        }

        // 내림차순 우선순위 큐
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n-1;i++){
            pq.add(Integer.parseInt(br.readLine()));
        }
        int count=0;
        // 큐의 맨 앞이 다솜이보다 크거나 같으면 계속 뺏어오기
        while(!pq.isEmpty()&&pq.peek()>=dasom){
            int top=pq.poll(); // 현재 1등 표를 가져와서
            top--; // 하나 뺏고
            dasom++; // 다솜이 주고
            count++; // 뺏은 횟수 증가
            pq.add(top); // 다시 큐에 넣어서 순위 재배치
        }

        System.out.print(count);
    }
}