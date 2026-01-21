import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 상근이가 가지고 있는 숫자 카드의 개수
        HashMap<Integer,Integer>map=new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            // default 0으로 된거에서 발견할때마다 +1
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int key = Integer.parseInt(st.nextToken());
            // map에 몇개 있는지 검색
            sb.append(map.getOrDefault(key,0)).append(" ");
        }
        System.out.print(sb.toString().trim());
    }
}