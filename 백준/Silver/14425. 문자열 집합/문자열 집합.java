import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 집합 S에 포합되어 있는 문자열
        int m = Integer.parseInt(st.nextToken()); // 검사해야 하는 문자열
        HashSet<String> set=new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        int count=0;
        for(int i=0;i<m;i++){
            String input=br.readLine();
            if(set.contains(input)){
                count++;
            }
        }
        System.out.print(count);
    }
}