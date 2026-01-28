import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine()); // 좌표 개수

        int []x=new int[n]; // 원본 순서 저장
        int []sorted=new int[n]; // 정렬용

        StringTokenizer st=new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            sorted[i]=x[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        HashMap<Integer,Integer> rankMap=new HashMap<>();
        int rank=0;
        for(int val:sorted){
            // 처음 등장하는 숫자에만 순위 부여, rank 증가
            if(!rankMap.containsKey(val)){
                rankMap.put(val,rank);
                rank++;
            }
        }

        // 원본 배열 돌면서 맵에서 순위 꺼내기
        StringBuilder sb=new StringBuilder();
        for(int val:x){
            sb.append(rankMap.get(val)).append(" ");
        }

        System.out.println(sb);
    }
}